(function (t) {
    function e(e) {
        for (var i, a, o = e[0], u = e[1], l = e[2], c = 0, p = []; c < o.length; c++)a = o[c], s[a] && p.push(s[a][0]), s[a] = 0;
        for (i in u)Object.prototype.hasOwnProperty.call(u, i) && (t[i] = u[i]);
        d && d(e);
        while (p.length)p.shift()();
        return r.push.apply(r, l || []), n()
    }

    function n() {
        for (var t, e = 0; e < r.length; e++) {
            for (var n = r[e], i = !0, a = 1; a < n.length; a++) {
                var u = n[a];
                0 !== s[u] && (i = !1)
            }
            i && (r.splice(e--, 1), t = o(o.s = n[0]))
        }
        return t
    }

    var i = {}, s = {app: 0}, r = [];

    function a(t) {
        return o.p + "js/" + ({about: "about"}[t] || t) + "." + {about: "920725a0"}[t] + ".js"
    }

    function o(e) {
        if (i[e])return i[e].exports;
        var n = i[e] = {i: e, l: !1, exports: {}};
        return t[e].call(n.exports, n, n.exports, o), n.l = !0, n.exports
    }

    o.e = function (t) {
        var e = [], n = s[t];
        if (0 !== n)if (n)e.push(n[2]); else {
            var i = new Promise(function (e, i) {
                n = s[t] = [e, i]
            });
            e.push(n[2] = i);
            var r, u = document.createElement("script");
            u.charset = "utf-8", u.timeout = 120, o.nc && u.setAttribute("nonce", o.nc), u.src = a(t), r = function (e) {
                u.onerror = u.onload = null, clearTimeout(l);
                var n = s[t];
                if (0 !== n) {
                    if (n) {
                        var i = e && ("load" === e.type ? "missing" : e.type), r = e && e.target && e.target.src, a = new Error("Loading chunk " + t + " failed.\n(" + i + ": " + r + ")");
                        a.type = i, a.request = r, n[1](a)
                    }
                    s[t] = void 0
                }
            };
            var l = setTimeout(function () {
                r({type: "timeout", target: u})
            }, 12e4);
            u.onerror = u.onload = r, document.head.appendChild(u)
        }
        return Promise.all(e)
    }, o.m = t, o.c = i, o.d = function (t, e, n) {
        o.o(t, e) || Object.defineProperty(t, e, {enumerable: !0, get: n})
    }, o.r = function (t) {
        "undefined" !== typeof Symbol && Symbol.toStringTag && Object.defineProperty(t, Symbol.toStringTag, {value: "Module"}), Object.defineProperty(t, "__esModule", {value: !0})
    }, o.t = function (t, e) {
        if (1 & e && (t = o(t)), 8 & e)return t;
        if (4 & e && "object" === typeof t && t && t.__esModule)return t;
        var n = Object.create(null);
        if (o.r(n), Object.defineProperty(n, "default", {
                enumerable: !0,
                value: t
            }), 2 & e && "string" != typeof t)for (var i in t)o.d(n, i, function (e) {
            return t[e]
        }.bind(null, i));
        return n
    }, o.n = function (t) {
        var e = t && t.__esModule ? function () {
            return t["default"]
        } : function () {
            return t
        };
        return o.d(e, "a", e), e
    }, o.o = function (t, e) {
        return Object.prototype.hasOwnProperty.call(t, e)
    }, o.p = "/", o.oe = function (t) {
        throw console.error(t), t
    };
    var u = window["webpackJsonp"] = window["webpackJsonp"] || [], l = u.push.bind(u);
    u.push = e, u = u.slice();
    for (var c = 0; c < u.length; c++)e(u[c]);
    var d = l;
    r.push([0, "chunk-vendors"]), n()
})({
    0: function (t, e, n) {
        t.exports = n("cd49")
    }, "0e07": function (t, e, n) {
    }, "4b28": function (t, e, n) {
        "use strict";
        var i = n("c223"), s = n.n(i);
        s.a
    }, "56c1": function (t, e, n) {
        "use strict";
        var i = n("6bac"), s = n.n(i);
        s.a
    }, "6bac": function (t, e, n) {
    }, "9b19": function (t, e, n) {
        t.exports = n.p + "img/logo.63a7d78d.svg"
    }, c223: function (t, e, n) {
    }, cd49: function (t, e, n) {
        "use strict";
        n.r(e);
        n("cadf"), n("551c"), n("097d");
        var i = n("2b0e"), s = n("bb71");
        n("da64");
        i["default"].use(s["a"], {iconfont: "md"});
        var r = function () {
            var t = this, e = t.$createElement, n = t._self._c || e;
            return n("v-app", {attrs: {id: "inspire", dark: ""}}, [n("v-navigation-drawer", {
                attrs: {
                    clipped: "",
                    fixed: "",
                    app: ""
                }, model: {
                    value: t.drawer, callback: function (e) {
                        t.drawer = e
                    }, expression: "drawer"
                }
            }, [n("v-list", {attrs: {dense: ""}}, t._l(t.menu, function (e) {
                return n("v-list-tile", {
                    key: e.$index,
                    attrs: {to: e.to},
                    on: {click: t.callback}
                }, [n("v-list-tile-action", [n("v-icon", [t._v(t._s(e.icon))])], 1), n("v-list-tile-content", [n("v-list-tile-title", [t._v(t._s(e.label))])], 1)], 1)
            }), 1)], 1), n("v-toolbar", {
                attrs: {
                    app: "",
                    fixed: "",
                    "clipped-left": ""
                }
            }, [n("v-toolbar-side-icon", {
                on: {
                    click: function (e) {
                        e.stopPropagation(), t.drawer = !t.drawer
                    }
                }
            }), n("v-toolbar-title", [t._v("VPV Math Puzzles")])], 1), n("v-content", [n("router-view")], 1), n("v-footer", {
                attrs: {
                    app: "",
                    fixed: ""
                }
            }, [n("span", {staticClass: "text-center"})]), n("v-footer", {
                attrs: {
                    height: "auto",
                    app: "",
                    fixed: ""
                }
            }, [n("v-layout", {
                attrs: {
                    "justify-center": "",
                    row: "",
                    wrap: ""
                }
            }, [t._v("\n      ©" + t._s((new Date).getFullYear()) + " - "), n("strong", [n("a", {attrs: {href: "https://me.vpv.io"}}, [t._v("Venkateswara VP")])])])], 1)], 1)
        }, a = [], o = {
            data: function () {
                return {
                    drawer: null,
                    menu: [{to: "/", icon: "home", label: "Home"}, {to: "/add", icon: "add", label: "Add"}, {
                        to: "/about",
                        icon: "info",
                        label: "About"
                    }]
                }
            }, props: {source: String}, methods: {
                callback: function () {
                }
            }
        }, u = o, l = n("2877"), c = n("6544"), d = n.n(c), p = n("7496"), m = n("549c"), h = n("553a"), f = n("132d"), v = n("a722"), b = n("8860"), x = n("ba95"), g = n("40fe"), y = n("5d23"), _ = n("f774"), w = n("71d9"), V = n("706c"), k = n("2a7f"), j = Object(l["a"])(u, r, a, !1, null, null, null), T = j.exports;
        d()(j, {
            VApp: p["a"],
            VContent: m["a"],
            VFooter: h["a"],
            VIcon: f["a"],
            VLayout: v["a"],
            VList: b["a"],
            VListTile: x["a"],
            VListTileAction: g["a"],
            VListTileContent: y["a"],
            VListTileTitle: y["b"],
            VNavigationDrawer: _["a"],
            VToolbar: w["a"],
            VToolbarSideIcon: V["a"],
            VToolbarTitle: k["a"]
        });
        var C = n("8c4f"), z = function () {
            var t = this, e = t.$createElement, n = t._self._c || e;
            return n("div", {staticClass: "home"}, [n("HelloWorld", {attrs: {msg: "Welcome to Your Vue.js + TypeScript App"}})], 1)
        }, A = [], P = n("9ab4"), N = n("60a3"), O = function () {
            var t = this, e = t.$createElement, i = t._self._c || e;
            return i("v-container", [i("v-layout", {
                attrs: {
                    "text-xs-center": "",
                    wrap: ""
                }
            }, [i("v-flex", {attrs: {xs12: ""}}, [i("v-img", {
                staticClass: "my-3",
                attrs: {src: n("9b19"), contain: "", height: "200"}
            })], 1), i("v-flex", {attrs: {"mb-4": ""}}, [i("h1", {staticClass: "display-2 font-weight-bold mb-3"}, [t._v("\n        Welcome to Vuetify\n      ")]), i("p", {staticClass: "subheading font-weight-regular"}, [t._v("\n        For help and collaboration with other Vuetify developers,\n        "), i("br"), t._v("please join our online\n        "), i("a", {
                attrs: {
                    href: "https://community.vuetifyjs.com",
                    target: "_blank"
                }
            }, [t._v("Discord Community")])])]), i("v-flex", {
                attrs: {
                    "mb-5": "",
                    xs12: ""
                }
            }, [i("h2", {staticClass: "headline font-weight-bold mb-3"}, [t._v("What's next?")]), i("v-layout", {attrs: {"justify-center": ""}}, t._l(t.whatsNext, function (e, n) {
                return i("a", {
                    key: n,
                    staticClass: "subheading mx-3",
                    attrs: {href: e.href, target: "_blank"}
                }, [t._v("\n          " + t._s(e.text) + "\n        ")])
            }), 0)], 1), i("v-flex", {
                attrs: {
                    xs12: "",
                    "mb-5": ""
                }
            }, [i("h2", {staticClass: "headline font-weight-bold mb-3"}, [t._v("Important Links")]), i("v-layout", {attrs: {"justify-center": ""}}, t._l(t.importantLinks, function (e, n) {
                return i("a", {
                    key: n,
                    staticClass: "subheading mx-3",
                    attrs: {href: e.href, target: "_blank"}
                }, [t._v("\n          " + t._s(e.text) + "\n        ")])
            }), 0)], 1), i("v-flex", {
                attrs: {
                    xs12: "",
                    "mb-5": ""
                }
            }, [i("h2", {staticClass: "headline font-weight-bold mb-3"}, [t._v("Ecosystem")]), i("v-layout", {attrs: {"justify-center": ""}}, t._l(t.ecosystem, function (e, n) {
                return i("a", {
                    key: n,
                    staticClass: "subheading mx-3",
                    attrs: {href: e.href, target: "_blank"}
                }, [t._v("\n          " + t._s(e.text) + "\n        ")])
            }), 0)], 1)], 1)], 1)
        }, S = [], $ = {
            data: function () {
                return {
                    ecosystem: [{
                        text: "vuetify-loader",
                        href: "https://github.com/vuetifyjs/vuetify-loader"
                    }, {text: "github", href: "https://github.com/vuetifyjs/vuetify"}, {
                        text: "awesome-vuetify",
                        href: "https://github.com/vuetifyjs/awesome-vuetify"
                    }],
                    importantLinks: [{text: "Documentation", href: "https://vuetifyjs.com"}, {
                        text: "Chat",
                        href: "https://community.vuetifyjs.com"
                    }, {text: "Made with Vuetify", href: "https://madewithvuetifyjs.com"}, {
                        text: "Twitter",
                        href: "https://twitter.com/vuetifyjs"
                    }, {text: "Articles", href: "https://medium.com/vuetify"}],
                    whatsNext: [{
                        text: "Explore components",
                        href: "https://vuetifyjs.com/components/api-explorer"
                    }, {
                        text: "Select a layout",
                        href: "https://vuetifyjs.com/layout/pre-defined"
                    }, {
                        text: "Frequently Asked Questions",
                        href: "https://vuetifyjs.com/getting-started/frequently-asked-questions"
                    }]
                }
            }
        }, E = $, F = n("a523"), L = n("0e8f"), B = n("adda"), R = Object(l["a"])(E, O, S, !1, null, null, null), D = R.exports;
        d()(R, {VContainer: F["a"], VFlex: L["a"], VImg: B["a"], VLayout: v["a"]});
        var I = function (t) {
            function e() {
                return null !== t && t.apply(this, arguments) || this
            }

            return P["b"](e, t), e = P["a"]([Object(N["a"])({components: {HelloWorld: D}})], e), e
        }(N["b"]), M = I, W = M, q = Object(l["a"])(W, z, A, !1, null, null, null), H = q.exports, U = function () {
            var t = this, e = t.$createElement, n = t._self._c || e;
            return n("div", {staticClass: "add text-xs-center"}, [n("p", [n("UserInput", {
                attrs: {
                    size: t.input.size,
                    min: t.input.min,
                    max: t.input.max,
                    duration: t.input.duration,
                    title: "Addition Problem"
                }, on: {"activate-timer": t.activate}
            })], 1), n("section", {attrs: {id: "stopWatch"}}, [n("p", {attrs: {id: "timer"}}, [t._v("Time : " + t._s(t.timer))])]), n("v-container", {
                attrs: {
                    "grid-list-md": "",
                    "text-xs-center": ""
                }
            }, [n("v-layout", {attrs: {row: "", wrap: ""}}, [t._l(t.responses, function (e) {
                return n("v-flex", {
                    key: e.$index,
                    attrs: {xs12: "", md6: "", lg4: ""}
                }, [n("ProblemDisplay", {attrs: {response: e, timer: t.timer}})], 1)
            }), n("v-divider"), n("v-flex", {attrs: {xs12: ""}}, [t.responses.length ? n("v-btn", {
                attrs: {color: "success"},
                on: {click: t.finish}
            }, [t._v("Finish")]) : t._e()], 1)], 2)], 1), n("v-divider"), n("v-flex", {attrs: {xs12: ""}}, [t.computedResult.total > 0 ? n("section", {staticClass: "result"}, [n("table", {
                staticClass: "results",
                attrs: {border: "1"}
            }, [n("tr", [n("th", [t._v("Total Questions ")]), n("td", [t._v(t._s(t.computedResult.total))])]), n("tr", [n("th", [t._v("Correct Answers ")]), n("td", [t._v(t._s(t.computedResult.correctAnswers))])]), n("tr", [n("th", [t._v("Your Score")]), n("td", [t._v(t._s(t.computedResult.score))])])])]) : t._e()])], 1)
        }, Y = [], J = (n("ac6a"), function () {
            var t = this, e = t.$createElement, n = t._self._c || e;
            return n("div", {staticClass: "problem-display"}, [n("v-card", [n("v-card-text", [n("v-badge", [t._v(" " + t._s(t.timer) + " ")]), n("div", {staticClass: "display-4 text-xs-right"}, [t._v(t._s(t.response.firstNumber))]), n("div", {staticClass: "display-4 text-xs-right"}, [t._v(t._s(t.response.operator) + " " + t._s(t.response.secondNumber))])], 1), n("v-card-actions", [n("v-text-field", {
                attrs: {
                    id: "styled-input",
                    height: "120",
                    type: "number",
                    name: "answer",
                    autocomplete: "off"
                }, model: {
                    value: t.response.result, callback: function (e) {
                        t.$set(t.response, "result", e)
                    }, expression: "response.result"
                }
            })], 1), n("v-btn", {
                attrs: {color: "green", dark: "", small: "", absolute: "", bottom: "", right: "", fab: ""},
                on: {
                    click: function (e) {
                        t.$vuetify.goTo(0)
                    }
                }
            }, [n("v-icon", [t._v("arrow_upward")])], 1)], 1)], 1)
        }), Q = [], G = (n("c5f6"), {
            name: "ProblemDisplay",
            props: {
                response: {firstNumber: Number, secondNumber: Number, answer: Number, result: Number, operator: String},
                timer: String
            }
        }), K = G, X = (n("d180"), n("4ca6")), Z = n("8336"), tt = n("b0af"), et = n("99d9"), nt = n("2677"), it = Object(l["a"])(K, J, Q, !1, null, "58b2eebd", null), st = it.exports;
        d()(it, {
            VBadge: X["a"],
            VBtn: Z["a"],
            VCard: tt["a"],
            VCardActions: et["a"],
            VCardText: et["b"],
            VIcon: f["a"],
            VTextField: nt["a"]
        });
        var rt = function () {
            var t = this, e = t.$createElement, n = t._self._c || e;
            return n("div", {staticClass: "user-input"}, [n("v-card", [n("v-card-title", {attrs: {"primary-title": ""}}, [n("div", [n("h3", {staticClass: "headline mb-0"}, [t._v(t._s(t.title))]), n("div", [t._v("Please enter the configuration to generate the puzzles")])])]), n("v-container", {
                attrs: {
                    "fill-height": "",
                    fluid: "",
                    "pa-2": ""
                }
            }, [n("v-layout", {attrs: {"fill-height": ""}}, [n("v-flex", {
                attrs: {
                    xs12: "",
                    lg4: "",
                    md8: "",
                    flexbox: ""
                }
            }, [n("v-text-field", {
                attrs: {label: "Number of problems", type: "number", name: "size"},
                model: {
                    value: t.input.size, callback: function (e) {
                        t.$set(t.input, "size", t._n(e))
                    }, expression: "input.size"
                }
            }), n("v-text-field", {
                attrs: {label: "Starting Value", type: "number", name: "min"},
                model: {
                    value: t.input.min, callback: function (e) {
                        t.$set(t.input, "min", t._n(e))
                    }, expression: "input.min"
                }
            }), n("v-text-field", {
                attrs: {label: "Ending Value", type: "number", name: "max"},
                model: {
                    value: t.input.max, callback: function (e) {
                        t.$set(t.input, "max", t._n(e))
                    }, expression: "input.max"
                }
            }), n("v-slider", {
                attrs: {
                    "thumb-size": 24,
                    hint: "Please choose the test duration.",
                    min: "1",
                    max: "15",
                    "thumb-label": "always",
                    label: "Duration in minutes"
                }, model: {
                    value: t.input.duration, callback: function (e) {
                        t.$set(t.input, "duration", t._n(e))
                    }, expression: "input.duration"
                }
            })], 1)], 1)], 1), n("v-card-actions", {staticClass: "justify-center"}, [n("v-btn", {
                attrs: {color: "green"},
                on: {click: t.activateTimer}
            }, [t._v("Start Timer")])], 1)], 1)], 1)
        }, at = [], ot = {
            name: "UserInput",
            data: function () {
                return {input: {size: this.size, min: this.min, max: this.max, duration: this.duration}}
            },
            props: {size: Number, min: Number, max: Number, duration: Number, title: String},
            methods: {
                activateTimer: function () {
                    console.log("Emmiting activate-timer event"), this.$emit("activate-timer", this.input.size, this.input.min, this.input.max, this.input.duration)
                }
            }
        }, ut = ot, lt = (n("4b28"), n("12b2")), ct = n("ba0d"), dt = Object(l["a"])(ut, rt, at, !1, null, "1bb78da3", null), pt = dt.exports;
        d()(dt, {
            VBtn: Z["a"],
            VCard: tt["a"],
            VCardActions: et["a"],
            VCardTitle: lt["a"],
            VContainer: F["a"],
            VFlex: L["a"],
            VLayout: v["a"],
            VSlider: ct["a"],
            VTextField: nt["a"]
        });
        var mt = n("5118"), ht = {
            name: "add", components: {UserInput: pt, ProblemDisplay: st}, data: function () {
                return {
                    responses: [],
                    responsesBackup: [],
                    timer: "00:00",
                    minutes: 0,
                    seconds: 0,
                    internal: {
                        mins: 2, seconds: 0, timeout: function () {
                        }
                    },
                    computedResult: {total: 0, correctAnswers: 0, score: 0},
                    input: {size: 10, min: 100, max: 999, duration: 2}
                }
            }, methods: {
                activate: function (t, e, n, i) {
                    var s = this;
                    console.log("calling activete(".concat(t, ", ").concat(e, ", ").concat(n, ", ").concat(i, " )")), this.input.size = t, this.input.min = e, this.input.max = n, this.input.duration = i, fetch("/api/add?size=" + this.input.size + "&min=" + this.input.min + "&max=" + this.input.max).then(function (t) {
                        return t.json()
                    }).then(function (t) {
                        s.responsesBackup = [], s.responses = t, s.initTimer()
                    })
                }, finish: function () {
                    this.result()
                }, result: function () {
                    var t = this, e = [];
                    this.responses && this.responses.length ? e = this.responses : this.responsesBackup && this.responsesBackup.length ? e = this.responsesBackup : console.log("No Test in progress"), e && e.length && (this.computedResult.total = e.length, this.computedResult.correctAnswers = 0, e.forEach(function (n) {
                        n.answer === n.result && (t.computedResult.correctAnswers++, t.computedResult.score = 100 * t.computedResult.correctAnswers / e.length)
                    }))
                }, initTimer: function () {
                    this.clearTimer(), this.internal.mins = this.input.duration, this.internal.seconds = 60 * this.internal.mins, this.internal.timeout = setTimeout(this.timerFunction, this.internal.seconds)
                }, clearTimer: function () {
                    this.minutes = this.pad(0, 2), this.seconds = this.pad(0, 2), this.internal.timeout && this.internal.timeout.close && Object(mt["clearTimeout"])(this.internal.timeout)
                }, pad: function (t, e, n) {
                    return n = n || "0", t += "", t.length >= e ? t : new Array(e - t.length + 1).join(n) + t
                }, getminutes: function () {
                    return this.internal.mins = Math.floor(this.internal.seconds / 60), this.pad(this.internal.mins, 2)
                }, getseconds: function () {
                    return this.pad(this.internal.seconds - Math.round(60 * this.internal.mins), 2)
                }, timerFunction: function () {
                    this.internal.seconds < 59 ? this.seconds = this.internal.seconds : (this.minutes = this.getminutes(), this.seconds = this.getseconds()), this.internal.seconds < 0 ? (this.responsesBackup = this.responses, this.responses = [], this.clearTimer()) : (this.internal.seconds--, this.internal.timeout = setTimeout(this.timerFunction, 1e3)), this.timer = this.minutes + ":" + this.seconds
                }
            }, created: function () {
                this.clearTimer()
            }
        }, ft = ht, vt = (n("56c1"), n("ce7e")), bt = Object(l["a"])(ft, U, Y, !1, null, "7c4b5cf1", null), xt = bt.exports;
        d()(bt, {
            VBtn: Z["a"],
            VContainer: F["a"],
            VDivider: vt["a"],
            VFlex: L["a"],
            VLayout: v["a"]
        }), i["default"].use(C["a"]);
        var gt = new C["a"]({
            mode: "history",
            routes: [{path: "/", name: "home", component: H}, {path: "/add", name: "add", component: xt}, {
                path: "/about",
                name: "about",
                component: function () {
                    return n.e("about").then(n.bind(null, "f820"))
                }
            }]
        });
        i["default"].config.productionTip = !1, new i["default"]({
            router: gt, render: function (t) {
                return t(T)
            }
        }).$mount("#app")
    }, d180: function (t, e, n) {
        "use strict";
        var i = n("0e07"), s = n.n(i);
        s.a
    }
});
//# sourceMappingURL=app.c676e2e0.js.map