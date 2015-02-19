package mk.icelabs.gwt.polymer.client.core;


import java.io.PrintWriter;

import mk.icelabs.gwt.polymer.client.ui.BindingPropertySet.PropertyName;
import mk.icelabs.gwt.polymer.client.ui.BindingPropertySet.PropertyValue;

import com.google.gwt.core.ext.BadPropertyValueException;
import com.google.gwt.core.ext.Generator;
import com.google.gwt.core.ext.GeneratorContext;
import com.google.gwt.core.ext.SelectionProperty;
import com.google.gwt.core.ext.TreeLogger;
import com.google.gwt.core.ext.TreeLogger.Type;
import com.google.gwt.core.ext.UnableToCompleteException;
import com.google.gwt.core.ext.typeinfo.JClassType;
import com.google.gwt.core.ext.typeinfo.JMethod;
import com.google.gwt.core.ext.typeinfo.JPrimitiveType;
import com.google.gwt.core.ext.typeinfo.TypeOracle;
import com.google.gwt.dev.util.Name;
import com.google.gwt.user.rebind.ClassSourceFileComposerFactory;
import com.google.gwt.user.rebind.SourceWriter;

public class BindingPropertyGenerator extends Generator {

  @Override
  public String generate(TreeLogger logger, GeneratorContext context, String typeName) throws UnableToCompleteException {
    TypeOracle oracle = context.getTypeOracle();

    JClassType toGenerate = oracle.findType(typeName).isInterface();
    if (toGenerate == null) {
      logger.log(Type.ERROR, typeName + " is not an interface");
      throw new UnableToCompleteException();
    }

    PropertyName annotation = toGenerate.getAnnotation(PropertyName.class);
    if (annotation == null) {
      logger.log(Type.ERROR, "Cannot generate with a @PropertyName anntation on the type");
      throw new UnableToCompleteException();
    }

    String propertyName = annotation.value();
    SelectionProperty property;
    String value;
    try {
      property = context.getPropertyOracle().getSelectionProperty(logger, propertyName);
      value = property.getCurrentValue();
    } catch (BadPropertyValueException e) {
      logger.log(Type.ERROR, "Error occured loading property: ", e);
      throw new UnableToCompleteException();
    }
    String packageName = toGenerate.getPackage().getName();
    String simpleSourceName = toGenerate.getName().replace('.', '_') + "_" + value;
    PrintWriter pw = context.tryCreate(logger, packageName, simpleSourceName);
    if (pw == null) {
      return packageName + "." + simpleSourceName;
    }

    ClassSourceFileComposerFactory factory = new ClassSourceFileComposerFactory(packageName, simpleSourceName);
    factory.addImplementedInterface(typeName);
    SourceWriter sw = factory.createSourceWriter(context, pw);

    for (JMethod method : toGenerate.getMethods()) {
      if (method.getReturnType().isPrimitive() != JPrimitiveType.BOOLEAN
          && !method.getReturnType().isClass().getQualifiedSourceName().equals(
              Name.getSourceNameForClass(Boolean.class))) {
        logger.log(Type.ERROR, "Methods must return boolean or Boolean");
        throw new UnableToCompleteException();
      }
      sw.println("%1$s {", method.getReadableDeclaration(false, true, true, true, true));

      PropertyValue val = method.getAnnotation(PropertyValue.class);
      if (val == null) {
        logger.log(Type.ERROR, "Method must have a @PropertyValue annotation");
        throw new UnableToCompleteException();
      }

      if (!property.getPossibleValues().contains(val.value()) && val.warn()) {
        logger.log(Type.WARN, "Value '" + val
            + "' is not present in the current set of possible values for selection property " + propertyName);
      }
      sw.indentln("return %1$b;", val.value().equals(value));

      sw.println("}");
    }

    sw.commit(logger);

    return factory.getCreatedClassName();
  }

}
