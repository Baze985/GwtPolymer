package mk.icelabs.gwt.polymer.client.dom;


import com.google.gwt.core.client.JavaScriptObject;

/**
 * Loads the ext javascript to make available Ext, Element, DomHelper, DomQuery,
 * and Template objects available. Only the parts of the library being used are
 * loaded and were manually moved into the class. No event, listener, or
 * animation code is used. Provides low level dom related functions. A reference
 * to the Ext instance is set $wnd.GXT.Ext.
 */
class Ext {
  
  private static JavaScriptObject ext;

  /**
   * Loads the native ext javascript.
   */
  native static void loadExt() /*-{
		var document = $doc;
		var window = $wnd;
		
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		if (!!Ext) {
			return;
		}
		Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext = {};

		Ext.apply = function(o, c, defaults) {
			if (defaults) {
				// no "this" reference for friendly out of scope calls
				Ext.apply(o, defaults);
			}
			if (o && c && typeof c == 'object') {
				for ( var p in c) {
					o[p] = c[p];
				}
			}
			return o;
		};
		var initload = function() {
			var idSeed = 0;

			Ext.apply(Ext, {
				emptyFn : function() {
				},
				applyIf : function(o, c) {
					if (o && c) {
						for ( var p in c) {
							if (typeof o[p] == "undefined") {
								o[p] = c[p];
							}
						}
					}
					return o;
				},

				isArray : function(v) {
					return v && typeof v.pop == 'function';
				},

				getDom : function(el) {
					if (!el || !$doc) {
						return null;
					}
					return el.dom ? el.dom : (typeof el == 'string' ? document
							.getElementById(el) : el);
				},

				isTextNode : function(value) {
					return value ? value.nodeName === "#text" : false;
				},
			});
		};

		Ext.supports = {};

		Ext.supports.Range = function() {
			return !!$doc.createRange;
		};

		Ext.supports.CreateContextualFragment = function() {
			var range = Ext.supports.Range ? $doc.createRange() : false;
			return range && !!range.createContextualFragment;
		};

		initload();
  }-*/;

  

  native static void loadDomQuery() /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;
		if (!!Ext.DomQuery) {
			return;
		}

		Ext.DomQuery = function() {
			var cache = {}, simpleCache = {}, valueCache = {};
			var nonSpace = /\S/;
			var trimRe = /^\s+|\s+$/g;
			var tplRe = /\{(\d+)\}/g;
			var modeRe = /^(\s?[\/>+~]\s?|\s|$)/;
			var tagTokenRe = /^(#)?([\w-\*]+)/;
			var nthRe = /(\d*)n\+?(\d*)/, nthRe2 = /\D/;
			var document = $doc;
			var functions = {};
			function child(p, index) {
				var i = 0;
				var n = p.firstChild;
				while (n) {
					if (n.nodeType == 1) {
						if (++i == index) {
							return n;
						}
					}
					n = n.nextSibling;
				}
				return null;
			}
			;
			function next(n) {
				while ((n = n.nextSibling) && n.nodeType != 1)
					;
				return n;
			}
			;
			function prev(n) {
				while ((n = n.previousSibling) && n.nodeType != 1)
					;
				return n;
			}
			;
			function children(d) {
				var n = d.firstChild, ni = -1;
				while (n) {
					var nx = n.nextSibling;
					if (n.nodeType == 3 && !nonSpace.test(n.nodeValue)) {
						d.removeChild(n);
					} else {
						n.nodeIndex = ++ni;
					}
					n = nx;
				}
				return this;
			}
			;
			functions["byClassName"] = byClassName;
			function byClassName(c, a, v) {
				if (!v) {
					return c;
				}
				var r = [], ri = -1, cn;
				for ( var i = 0, ci; ci = c[i]; i++) {
					if ((' ' + ci.className + ' ').indexOf(v) != -1) {
						r[++ri] = ci;
					}
				}
				return r;
			};
			functions["attrValue"] = attrValue;
			function attrValue(n, attr) {
				if (!n.tagName && typeof n.length != "undefined") {
					n = n[0];
				}
				if (!n) {
					return null;
				}
				if (attr == "for") {
					return n.htmlFor;
				}
				if (attr == "class" || attr == "className") {
					return n.className;
				}
				return n.getAttribute(attr) || n[attr];
			};
			functions["getNodes"] = getNodes;
			function getNodes(ns, mode, tagName) {
				var result = [], ri = -1, cs;
				if (!ns) {
					return result;
				}
				tagName = tagName || "*";
				if (typeof ns.getElementsByTagName != "undefined") {
					ns = [ ns ];
				}
				if (!mode) {
					for ( var i = 0, ni; ni = ns[i]; i++) {
					    if (tagName == "*") {
					        cs = ni.getElementsByTagName("*");
					    } else if (typeof ni.getElementsByTagNameNS != "undefined") {
						    cs = ni.getElementsByTagNameNS("*", tagName);
					    } else {
					        cs = ni.getElementsByTagName(tagName);
					    }
						for ( var j = 0, ci; ci = cs[j]; j++) {
							result[++ri] = ci;
						}
					}
				} else if (mode == "/" || mode == ">") {
					var utag = tagName.toUpperCase();
					for ( var i = 0, ni, cn; ni = ns[i]; i++) {
						cn = ni.children || ni.childNodes;
						for ( var j = 0, cj; cj = cn[j]; j++) {
							if (cj.nodeName == utag || cj.nodeName == tagName
									|| tagName == '*') {
								result[++ri] = cj;
							}
						}
					}
				} else if (mode == "+") {
					var utag = tagName.toUpperCase();
					for ( var i = 0, n; n = ns[i]; i++) {
						while ((n = n.nextSibling) && n.nodeType != 1)
							;
						if (n
								&& (n.nodeName == utag || n.nodeName == tagName || tagName == '*')) {
							result[++ri] = n;
						}
					}
				} else if (mode == "~") {
					for ( var i = 0, n; n = ns[i]; i++) {
						while ((n = n.nextSibling)
								&& (n.nodeType != 1 || (tagName == '*' || n.tagName
										.toLowerCase() != tagName)))
							;
						if (n) {
							result[++ri] = n;
						}
					}
				}
				return result;
			};
			function concat(a, b) {
				if (b.slice) {
					return a.concat(b);
				}
				for ( var i = 0, l = b.length; i < l; i++) {
					a[a.length] = b[i];
				}
				return a;
			}
			functions["byTag"] = byTag;
			function byTag(cs, tagName) {
				if (cs.tagName || cs == document) {
					cs = [ cs ];
				}
				if (!tagName) {
					return cs;
				}
				var r = [], ri = -1;
				tagName = tagName.toLowerCase();
				for ( var i = 0, ci; ci = cs[i]; i++) {
					if (ci.nodeType == 1 && ci.tagName.toLowerCase() == tagName) {
						r[++ri] = ci;
					}
				}
				return r;
			};
			functions["byId"] = byId;
			function byId(cs, attr, id) {
				if (cs.tagName || cs == document) {
					cs = [ cs ];
				}
				if (!id) {
					return cs;
				}
				var r = [], ri = -1;
				for ( var i = 0, ci; ci = cs[i]; i++) {
					if (ci && ci.id == id) {
						r[++ri] = ci;
						return r;
					}
				}
				return r;
			};
			functions["byAttribute"] = byAttribute;
			function byAttribute(cs, attr, value, op, custom) {
				var r = [], ri = -1, st = custom == "{";
				var f = Ext.DomQuery.operators[op];
				for ( var i = 0, ci; ci = cs[i]; i++) {
					var a;
					if (st) {
						a = Ext.DomQuery.getStyle(ci, attr);
					} else if (attr == "class" || attr == "className") {
						a = ci.className;
					} else if (attr == "for") {
						a = ci.htmlFor;
					} else if (attr == "href") {
						a = ci.getAttribute("href", 2);
					} else {
						a = ci.getAttribute(attr);
					}
					if ((f && f(a, value)) || (!f && a)) {
						r[++ri] = ci;
					}
				}
				return r;
			};
			functions["byPseudo"] = byPsuedo;
			function byPsuedo(cs, name, value) {
				return Ext.DomQuery.pseudos[name](cs, value);
			};
			// This is for IE MSXML which does not support expandos.
			// IE runs the same speed using setAttribute, however FF slows way down
			// and Safari completely fails so they need to continue to use expandos.
			var isIE = window.ActiveXObject ? true : false;
			// this eval is stop the compressor from
			// renaming the variable to something shorter
			eval("var batch = 30803;");
			var key = 30803;
			function nodupIEXml(cs) {
				var d = ++key;
				cs[0].setAttribute("_nodup", d);
				var r = [ cs[0] ];
				for ( var i = 1, len = cs.length; i < len; i++) {
					var c = cs[i];
					if (!c.getAttribute("_nodup") != d) {
						c.setAttribute("_nodup", d);
						r[r.length] = c;
					}
				}
				for ( var i = 0, len = cs.length; i < len; i++) {
					cs[i].removeAttribute("_nodup");
				}
				return r;
			}
			functions["_nodup"] = _nodup;
			function _nodup(cs) {
				if (!cs) {
					return [];
				}
				var len = cs.length, c, i, r = cs, cj, ri = -1;
				if (!len || typeof cs.nodeType != "undefined" || len == 1) {
					return cs;
				}
				if (isIE && typeof cs[0].selectSingleNode != "undefined") {
					return nodupIEXml(cs);
				}
				var d = ++key;
				cs[0]._nodup = d;
				for (i = 1; c = cs[i]; i++) {
					if (c._nodup != d) {
						c._nodup = d;
					} else {
						r = [];
						for ( var j = 0; j < i; j++) {
							r[++ri] = cs[j];
						}
						for (j = i + 1; cj = cs[j]; j++) {
							if (cj._nodup != d) {
								cj._nodup = d;
								r[++ri] = cj;
							}
						}
						return r;
					}
				}
				return r;
			}
			function quickDiffIEXml(c1, c2) {
				var d = ++key;
				for ( var i = 0, len = c1.length; i < len; i++) {
					c1[i].setAttribute("_qdiff", d);
				}
				var r = [];
				for ( var i = 0, len = c2.length; i < len; i++) {
					if (c2[i].getAttribute("_qdiff") != d) {
						r[r.length] = c2[i];
					}
				}
				for ( var i = 0, len = c1.length; i < len; i++) {
					c1[i].removeAttribute("_qdiff");
				}
				return r;
			}
			function quickDiff(c1, c2) {
				var len1 = c1.length;
				if (!len1) {
					return c2;
				}
				if (isIE && c1[0].selectSingleNode) {
					return quickDiffIEXml(c1, c2);
				}
				var d = ++key;
				for ( var i = 0; i < len1; i++) {
					c1[i]._qdiff = d;
				}
				var r = [];
				for ( var i = 0, len = c2.length; i < len; i++) {
					if (c2[i]._qdiff != d) {
						r[r.length] = c2[i];
					}
				}
				return r;
			}
			functions["quickId"] = quickId;
			function quickId(ns, mode, root, id) {
				if (ns == root) {
					var d = root.ownerDocument || root;
					return d.getElementById(id);
				}
				ns = getNodes(ns, mode, "*");
				return byId(ns, null, id);
			}
			return {
				getStyle : function(el, name) {
					//return @com.sencha.gxt.ui.client.core.XElement::fly(Lcom/google/gwt/dom/client/Element;)(el).@com.sencha.gxt.ui.client.core.XElement::getStyle()(Ljava/lang/String;)(name);
					return el.style[name];
				},
				compile : function(path, type) {
					type = type || "select";
					var fn = [ "var f = function(root, f){\n var mode; ++batch; var n = root || document;\n" ];
					var q = path, mode, lq;
					var tk = Ext.DomQuery.matchers;
					var tklen = tk.length;
					var mm;
					// accept leading mode switch
					var lmode = q.match(modeRe);
					if (lmode && lmode[1]) {
						fn[fn.length] = 'mode="' + lmode[1].replace(trimRe, "")
								+ '";';
						q = q.replace(lmode[1], "");
					}
					// strip leading slashes
					while (path.substr(0, 1) == "/") {
						path = path.substr(1);
					}
					while (q && lq != q) {
						lq = q;
						var tm = q.match(tagTokenRe);
						if (type == "select") {
							if (tm) {
								if (tm[1] == "#") {
									fn[fn.length] = 'n = f.quickId(n, mode, root, "'
											+ tm[2] + '");';
								} else {
									fn[fn.length] = 'n = f.getNodes(n, mode, "'
											+ tm[2] + '");';
								}
								q = q.replace(tm[0], "");
							} else if (q.substr(0, 1) != '@') {
								fn[fn.length] = 'n = f.getNodes(n, mode, "*");';
							}
						} else {
							if (tm) {
								if (tm[1] == "#") {
									fn[fn.length] = 'n = f.byId(n, null, "'
											+ tm[2] + '");';
								} else {
									fn[fn.length] = 'n = f.byTag(n, "'
											+ tm[2] + '");';
								}
								q = q.replace(tm[0], "");
							}
						}
						while (!(mm = q.match(modeRe))) {
							var matched = false;
							for ( var j = 0; j < tklen; j++) {
								var t = tk[j];
								var m = q.match(t.re);
								if (m) {
									fn[fn.length] = t.select.replace(tplRe,
											function(x, i) {
												return m[i];
											});
									q = q.replace(m[0], "");
									matched = true;
									break;
								}
							}
							// prevent infinite loop on bad selector
							if (!matched) {
								throw 'Error parsing selector, parsing failed at "'
										+ q + '"';
							}
						}
						if (mm[1]) {
							fn[fn.length] = 'mode="'
									+ mm[1].replace(trimRe, "") + '";';
							q = q.replace(mm[1], "");
						}
					}
					fn[fn.length] = "return f._nodup(n);\n}";
					eval(fn.join(""));
					return f;
				},
				select : function(path, root, type) {
					if (!root || root == document) {
						root = document;
					}
					if (typeof root == "string") {
						root = document.getElementById(root);
					}
					var paths = path.split(",");
					var results = [];
					for ( var i = 0, len = paths.length; i < len; i++) {
						var p = paths[i].replace(trimRe, "");
						if (!cache[p]) {
							cache[p] = Ext.DomQuery.compile(p);
							if (!cache[p]) {
								throw p + " is not a valid selector";
							}
						}
						var result = cache[p](root, functions);
						if (result && result != document) {
							results = results.concat(result);
						}
					}
					if (paths.length > 1) {
						return _nodup(results);
					}
					return results;
				},
				selectNode : function(path, root) {
					return Ext.DomQuery.select(path, root)[0];
				},
				selectValue : function(path, root, defaultValue) {
					path = path.replace(trimRe, "");
					if (!valueCache[path]) {
						valueCache[path] = Ext.DomQuery.compile(path, "select");
					}
					var n = valueCache[path](root, functions);
					n = n[0] ? n[0] : n;
					var v = (n && n.firstChild ? n.firstChild.nodeValue : null);
					return ((v === null || v === undefined || v === '') ? defaultValue
							: v);
				},
				selectNumber : function(path, root, defaultValue) {
					var v = Ext.DomQuery.selectValue(path, root,
							defaultValue || 0);
					return parseFloat(v);
				},
				is : function(el, ss) {
					if (typeof el == "string") {
						el = document.getElementById(el);
					}
					var isArray = (el instanceof Array);
					var result = Ext.DomQuery.filter(isArray ? el : [ el ], ss);
					return isArray ? (result.length == el.length)
							: (result.length > 0);
				},
				filter : function(els, ss, nonMatches) {
					ss = ss.replace(trimRe, "");
					if (!simpleCache[ss]) {
						simpleCache[ss] = Ext.DomQuery.compile(ss, "simple");
					}
					var result = simpleCache[ss](els, functions);
					return nonMatches ? quickDiff(result, els) : result;
				},
				matchers : [
						{
							re : /^\.([\w-]+)/,
							select : 'n = f.byClassName(n, null, " {1} ");'
						},
						{
							re : /^\:([\w-]+)(?:\(((?:[^\s>\/]*|.*?))\))?/,
							select : 'n = f.byPseudo(n, "{1}", "{2}");'
						},
						{
							re : /^(?:([\[\{])(?:@)?([\w-]+)\s?(?:(=|.=)\s?['"]?(.*?)["']?)?[\]\}])/,
							select : 'n = f.byAttribute(n, "{2}", "{4}", "{3}", "{1}");'
						},
						{
							re : /^#([\w-]+)/,
							select : 'n = f.byId(n, null, "{1}");'
						},
						{
							re : /^@([\w-:]+)/,
							select : 'return {firstChild:{nodeValue:f.attrValue(n, "{1}")}};'
						} ],
				operators : {
					"=" : function(a, v) {
						return a == v;
					},
					"!=" : function(a, v) {
						return a != v;
					},
					"^=" : function(a, v) {
						return a && a.substr(0, v.length) == v;
					},
					"$=" : function(a, v) {
						return a && a.substr(a.length - v.length) == v;
					},
					"*=" : function(a, v) {
						return a && a.indexOf(v) !== -1;
					},
					"%=" : function(a, v) {
						return (a % v) == 0;
					},
					"|=" : function(a, v) {
						return a
								&& (a == v || a.substr(0, v.length + 1) == v
										+ '-');
					},
					"~=" : function(a, v) {
						return a
								&& (' ' + a + ' ').indexOf(' ' + v + ' ') != -1;
					}
				},
				pseudos : {
					"first-child" : function(c) {
						var r = [], ri = -1, n;
						for ( var i = 0, ci; ci = n = c[i]; i++) {
							while ((n = n.previousSibling) && n.nodeType != 1)
								;
							if (!n) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"last-child" : function(c) {
						var r = [], ri = -1, n;
						for ( var i = 0, ci; ci = n = c[i]; i++) {
							while ((n = n.nextSibling) && n.nodeType != 1)
								;
							if (!n) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"nth-child" : function(c, a) {
						var r = [], ri = -1;
						var m = nthRe.exec(a == "even" && "2n" || a == "odd"
								&& "2n+1" || !nthRe2.test(a) && "n+" + a || a);
						var f = (m[1] || 1) - 0, l = m[2] - 0;
						for ( var i = 0, n; n = c[i]; i++) {
							var pn = n.parentNode;
							if (batch != pn._batch) {
								var j = 0;
								for ( var cn = pn.firstChild; cn; cn = cn.nextSibling) {
									if (cn.nodeType == 1) {
										cn.nodeIndex = ++j;
									}
								}
								pn._batch = batch;
							}
							if (f == 1) {
								if (l == 0 || n.nodeIndex == l) {
									r[++ri] = n;
								}
							} else if ((n.nodeIndex + l) % f == 0) {
								r[++ri] = n;
							}
						}
						return r;
					},
					"only-child" : function(c) {
						var r = [], ri = -1;
						;
						for ( var i = 0, ci; ci = c[i]; i++) {
							if (!prev(ci) && !next(ci)) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"empty" : function(c) {
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							var cns = ci.childNodes, j = 0, cn, empty = true;
							while (cn = cns[j]) {
								++j;
								if (cn.nodeType == 1 || cn.nodeType == 3) {
									empty = false;
									break;
								}
							}
							if (empty) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"contains" : function(c, v) {
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							if ((ci.textContent || ci.innerText || '')
									.indexOf(v) != -1) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"nodeValue" : function(c, v) {
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							if (ci.firstChild && ci.firstChild.nodeValue == v) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"checked" : function(c) {
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							if (ci.checked == true) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"not" : function(c, ss) {
						return Ext.DomQuery.filter(c, ss, true);
					},
					"any" : function(c, selectors) {
						var ss = selectors.split('|');
						var r = [], ri = -1, s;
						for ( var i = 0, ci; ci = c[i]; i++) {
							for ( var j = 0; s = ss[j]; j++) {
								if (Ext.DomQuery.is(ci, s)) {
									r[++ri] = ci;
									break;
								}
							}
						}
						return r;
					},
					"odd" : function(c) {
						return this["nth-child"](c, "odd");
					},
					"even" : function(c) {
						return this["nth-child"](c, "even");
					},
					"nth" : function(c, a) {
						return c[a - 1] || [];
					},
					"first" : function(c) {
						return c[0] || [];
					},
					"last" : function(c) {
						return c[c.length - 1] || [];
					},
					"has" : function(c, ss) {
						var s = Ext.DomQuery.select;
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							if (s(ss, ci).length > 0) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"next" : function(c, ss) {
						var is = Ext.DomQuery.is;
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							var n = next(ci);
							if (n && is(n, ss)) {
								r[++ri] = ci;
							}
						}
						return r;
					},
					"prev" : function(c, ss) {
						var is = Ext.DomQuery.is;
						var r = [], ri = -1;
						for ( var i = 0, ci; ci = c[i]; i++) {
							var n = prev(ci);
							if (n && is(n, ss)) {
								r[++ri] = ci;
							}
						}
						return r;
					}
				}
			};
		}();
  }-*/;

  native static void loadDomHelper() /*-{
		var Ext = @mk.icelabs.gwt.polymer.client.dom.Ext::ext;

		if (!!Ext.DomHelper) {
			return;
		}
		Ext.DomHelper = function() {
			var tempTableEl = null;
			var emptyTags = /^(?:br|frame|hr|img|input|link|meta|range|spacer|wbr|area|param|col)$/i;

			var tableRe = /^table|tbody|tr|td$/i;
			var tableElRe = /td|tr|tbody/i;
			
			var endRe = /end/i;

			var ieTable = function(depth, s, h, e) {
				this.tempTableEl.innerHTML = [ s, h, e ].join('');

				var i = -1, el = this.tempTableEl, ns;

				while (++i < depth) {
					el = el.firstChild;
				}

				// If the result is multiple siblings, then encapsulate them into one fragment.
				ns = el.nextSibling;

				if (ns) {
					var df = $doc.createDocumentFragment();

					while (el) {
						ns = el.nextSibling;
						df.appendChild(el);
						el = ns;
					}
					el = df;
				}
				return el;
			};

			// kill repeat to save bytes
			var afterbegin = 'afterbegin', afterend = 'afterend', beforebegin = 'beforebegin', beforeend = 'beforeend', ts = '<table>', te = '</table>', tbs = ts
					+ '<tbody>', tbe = '</tbody>' + te, trs = tbs + '<tr>', tre = '</tr>'
					+ tbe;

			var insertIntoTable = function(tag, where, el, html) {
				var node, before;

				this.tempTableEl = this.tempTableEl
						|| $doc.createElement('div');

				if (tag == 'td' && (where == afterbegin || where == beforeend)
						|| !tableElRe.test(tag)
						&& (where == beforebegin || where == afterend)) {
					return null;
				}
				before = where == beforebegin ? el
						: where == afterend ? el.nextSibling
								: where == afterbegin ? el.firstChild : null;

				if (where == beforebegin || where == afterend) {
					el = el.parentNode;
				}

				if (tag == 'td'
						|| (tag == 'tr' && (where == beforeend || where == afterbegin))) {
					node = ieTable(4, trs, html, tre);
				} else if ((tag == 'tbody' && (where == beforeend || where == afterbegin))
						|| (tag == 'tr' && (where == beforebegin || where == afterend))) {
					node = ieTable(3, tbs, html, tbe);
				} else {
					node = ieTable(2, ts, html, te);
				}

				el.insertBefore(node, before);

				return node;
			};

			return {

				markup : function(o) {
					return o;
				},

				createContextualFragment : function(html) {
					var div = $doc.createElement("div"), fragment = $doc
							.createDocumentFragment(), i = 0, length, childNodes;

					div.innerHTML = html;
					childNodes = div.childNodes;
					length = childNodes.length;

					for (; i < length; i++) {
						fragment.appendChild(childNodes[i].cloneNode(true));
					}

					return fragment;
				},

				applyStyles : function(el, styles) {
					if (styles) {
						if (typeof styles == "string") {
							var re = /\s?([a-z\-]*)\:\s?([^;]*);?/gi;
							var matches;
							while ((matches = re.exec(styles)) != null) {
								el.style[matches[1]] = matches[2];
							}
						} else if (typeof styles == "object") {
							for ( var style in styles) {
								//@com.sencha.gxt.ui.client.core.XElement::as(Lcom/google/gwt/dom/client/Node;)(el).@com.sencha.gxt.ui.client.core.XElement::applyStyles(Ljava/lang/String;)(styles[style]);
							}
						} else if (typeof styles == "function") {
							Ext.DomHelper.applyStyles(el, styles.call());
						}
					}
				},

				insertHtml : function(where, el, html) {
					var hash = {}, hashVal, range, rangeEl, setStart, frag, rs;

					where = where.toLowerCase();
					// add these here because they are used in both branches of the condition.
					hash[beforebegin] = [ 'BeforeBegin', 'previousSibling' ];
					hash[afterend] = [ 'AfterEnd', 'nextSibling' ];

					// if IE and context element is an HTMLElement
					if (el.insertAdjacentHTML) {
						if (tableRe.test(el.tagName)
								&& (rs = insertIntoTable(el.tagName
										.toLowerCase(), where, el, html))) {
							return rs;
						}

						// add these two to the hash.
						hash[afterbegin] = [ 'AfterBegin', 'firstChild' ];
						hash[beforeend] = [ 'BeforeEnd', 'lastChild' ];
						if ((hashVal = hash[where])) {
							el.insertAdjacentHTML(hashVal[0], html);
							return el[hashVal[1]];
						}
						// if (not IE and context element is an HTMLElement) or TextNode
					} else {
						// we cannot insert anything inside a textnode so...
						if (Ext.isTextNode(el)) {
							where = where === 'afterbegin' ? 'beforebegin'
									: where;
							where = where === 'beforeend' ? 'afterend' : where;
						}

						range = Ext.supports.CreateContextualFragment ? el.ownerDocument
								.createRange()
								: undefined;
						setStart = 'setStart'
								+ (endRe.test(where) ? 'After' : 'Before');
						if (hash[where]) {
							if (range) {
								range[setStart](el);
								frag = range.createContextualFragment(html);
							} else {
								frag = this.createContextualFragment(html);
							}
							el.parentNode.insertBefore(frag,
									where == beforebegin ? el : el.nextSibling);
							return el[(where == beforebegin ? 'previous'
									: 'next')
									+ 'Sibling'];
						} else {
							rangeEl = (where == afterbegin ? 'first' : 'last')
									+ 'Child';
							if (el.firstChild) {
								if (range) {
									range[setStart](el[rangeEl]);
									frag = range.createContextualFragment(html);
								} else {
									frag = this.createContextualFragment(html);
								}

								if (where == afterbegin) {
									el.insertBefore(frag, el.firstChild);
								} else {
									el.appendChild(frag);
								}
							} else {
								el.innerHTML = html;
							}
							return el[rangeEl];
						}
					}
				},

				insertBefore : function(el, o, returnElement) {
					return this.doInsert(el, o, returnElement, "beforeBegin");
				},

				insertAfter : function(el, o, returnElement) {
					return this.doInsert(el, o, returnElement, "afterEnd",
							"nextSibling");
				},

				insertFirst : function(el, o, returnElement) {
					return this.doInsert(el, o, returnElement, "afterBegin",
							"firstChild");
				},

				doInsert : function(el, o, returnElement, pos, sibling, append) {
					el = el.dom || Ext.getDom(el);
					var newNode = this.insertHtml(pos, el, this.markup(o));
					return returnElement ? Ext.get(newNode, true) : newNode;
				},

				append : function(el, o, returnElement) {
					return this.insertHtml("beforeEnd", el, o);
				},

				overwrite : function(el, o) {
					el.innerHTML = o;
					return el.firstChild;
				},

			};
		}();
  }-*/;
}
