webpackJsonp([1],{"/TLv":function(e,t){},"0OLz":function(e,t){},NHnr:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n("7+uW"),r={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("router-view")],1)},staticRenderFns:[]};var s=n("VU/8")({name:"App"},r,!1,function(e){n("ovje")},null,null).exports,a=n("/ocq"),i=n("Xxa5"),l=n.n(i),u=n("exGp"),c=n.n(u),m=n("Dd8w"),p=n.n(m),d=n("NYxO"),v={name:"login",data:function(){return{accountHint:"",pwdHint:"",rePwdHint:"",register:!1,loginForm:{username:"",password:"",repassword:""}}},methods:p()({},Object(d.b)(["saveUserInfo"]),{onLogin:function(){var e=this;return c()(l.a.mark(function t(){var n,o;return l.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(!e.loginForm.username||!e.loginForm.password){t.next=13;break}return n={username:e.loginForm.username,password:e.loginForm.password},t.prev=2,t.next=5,e.$http({method:"post",url:"/admin/login?email="+e.loginForm.username+"&passwordHash="+e.loginForm.password});case 5:200==(o=t.sent).code?(e.$store.dispatch("saveUserInfo",n),e.$router.push("/dashboard")):e.$alert(""+o.message,"错误提示",{confirmButtonText:"知道了",type:"error"}),console.log("****2***",o),t.next=13;break;case 10:t.prev=10,t.t0=t.catch(2),e.$alert("网络错误"+t.t0,"操作失败",{confirmButtonText:"知道了",type:"error"});case 13:case"end":return t.stop()}},t,e,[[2,10]])}))()},onRegister:function(){console.log("-----register------\x3e",this.loginForm),this.loginForm.username||""!=this.loginForm.username.trim()?this.accountHint="":this.accountHint="账号不能为空",this.loginForm.password||""!=this.loginForm.password.trim()?this.pwdHint="":this.pwdHint="密码不能为空",this.loginForm.repassword||""!=this.loginForm.repassword.trim()?this.rePwdHint="":this.rePwdHint="请再次确认密码",this.loginForm.password&&this.loginForm.repassword&&(this.loginForm.password!==this.loginForm.repassword?this.rePwdHint="两次密码填写不一致":this.rePwdHint=""),console.log("******",this.loginForm),this.accountHint===this.pwdHint===this.rePwdHint!==""&&this.handleRegister()},handleRegister:function(){var e=this;return c()(l.a.mark(function t(){var n;return l.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,e.$http({method:"post",url:"/api/userRegist",data:e.loginForm});case 3:200==(n=t.sent).code?(e.register=!1,e.$alert(""+n.message,"成功提示",{confirmButtonText:"知道了",type:"success"})):e.$alert(""+n.message,"错误提示",{confirmButtonText:"知道了",type:"error"}),console.log("****2***",n),t.next=11;break;case 8:t.prev=8,t.t0=t.catch(0),e.$alert("网络错误"+t.t0,"操作失败",{confirmButtonText:"知道了",type:"error"});case 11:case"end":return t.stop()}},t,e,[[0,8]])}))()}}),computed:{heightSize:{get:function(){return window.screen.availHeight+"px"}}}},g={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{style:{height:e.heightSize},attrs:{id:"content"}},[n("div",{staticClass:"login"},[n("div",{staticClass:"normal-title"},[n("a",{staticClass:"sign_in",on:{click:function(t){e.register=!1}}},[e._v("登录")]),e._v(" "),n("b",{staticStyle:{color:"#ea6f5a","font-weight":"bold"}},[e._v("·")]),e._v(" "),n("a",{staticClass:"sign_up",attrs:{id:"sign_up"},on:{click:function(t){e.register=!0}}},[e._v("注册")])]),e._v(" "),n("form",{staticClass:"loginForm"},[n("div",{staticStyle:{"margin-top":"30px"}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.loginForm.username,expression:"loginForm.username"},{name:"focus",rawName:"v-focus"}],attrs:{type:"text",name:"username",value:"",placeholder:"用户名","auto-complete":"off"},domProps:{value:e.loginForm.username},on:{input:function(t){t.target.composing||e.$set(e.loginForm,"username",t.target.value)}}}),e._v(" "),n("p",{staticStyle:{color:"red"}},[e._v(e._s(e.accountHint))])]),e._v(" "),n("div",{staticStyle:{"margin-top":"0px"}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.loginForm.password,expression:"loginForm.password"}],attrs:{type:"password",name:"password",value:"","auto-complete":"off",placeholder:"密码"},domProps:{value:e.loginForm.password},on:{input:function(t){t.target.composing||e.$set(e.loginForm,"password",t.target.value)}}}),e._v(" "),n("p",{staticStyle:{color:"red"}},[e._v(e._s(e.pwdHint))])]),e._v(" "),!0===e.register?n("div",{staticStyle:{"margin-top":"0px"}},[n("input",{directives:[{name:"model",rawName:"v-model",value:e.loginForm.repassword,expression:"loginForm.repassword"}],attrs:{type:"password",name:"password",value:"","auto-complete":"off",placeholder:"确认密码"},domProps:{value:e.loginForm.repassword},on:{input:function(t){t.target.composing||e.$set(e.loginForm,"repassword",t.target.value)}},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.onRegister(t):null}}}),e._v(" "),n("p",{staticStyle:{color:"red"}},[e._v(e._s(e.rePwdHint))])]):e._e(),e._v(" "),n("div",{staticClass:"btn",staticStyle:{"margin-top":"20px"}},[!1===e.register?n("button",{staticClass:"sign-in-button",attrs:{type:"button"},on:{click:e.onLogin}},[e._v("登录")]):e._e(),e._v(" "),!0===e.register?n("button",{staticClass:"sign-up-button",attrs:{type:"button"},on:{click:e.onRegister}},[e._v("注册")]):e._e()])])])])},staticRenderFns:[]};var f=n("VU/8")(v,g,!1,function(e){n("/TLv")},null,null).exports,_={data:function(){return{tableData:Array(20).fill({date:"2016-05-02",name:"王小虎",address:"上海市普陀区金沙江路 1518 弄"})}},methods:{handleOpen:function(e,t){console.log(e,t)},handleClose:function(e,t){console.log(e,t)},handlelLogout:function(){var e=this;return c()(l.a.mark(function t(){var n;return l.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return t.prev=0,t.next=3,e.$http({method:"get",url:"/api/logout"});case 3:200==(n=t.sent).code&&(console.log("****2***",n),e.$router.replace("/login")),t.next=10;break;case 7:t.prev=7,t.t0=t.catch(0),e.$alert("网络错误"+t.t0,"操作失败",{confirmButtonText:"知道了",type:"error"});case 10:case"end":return t.stop()}},t,e,[[0,7]])}))()}},computed:{barStyle:{get:function(){return"height:"+document.body.clientHeight+"px"}}}},h={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-container",{staticStyle:{border:"1px solid #eee"},style:e.barStyle},[n("el-aside",{attrs:{width:"200px"}},[n("el-menu",{staticClass:"el-menu-vertical-demo",style:e.barStyle,attrs:{"default-openeds":["2"],"background-color":"#224C67","text-color":"#fff","active-text-color":"#ffd04b"},on:{open:e.handleOpen,close:e.handleClose}},[n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-message"}),e._v("导航一")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"1-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"1-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"1-4-1"}},[e._v("选项4-1")])],2)],2),e._v(" "),n("el-submenu",{attrs:{index:"2"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-menu"}),e._v("导航二")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"2-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"2-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"2-4-1"}},[e._v("选项4-1")])],2)],2),e._v(" "),n("el-submenu",{attrs:{index:"3"}},[n("template",{slot:"title"},[n("i",{staticClass:"el-icon-setting"}),e._v("导航三")]),e._v(" "),n("el-menu-item-group",[n("template",{slot:"title"},[e._v("分组一")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-1"}},[e._v("选项1")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-2"}},[e._v("选项2")])],2),e._v(" "),n("el-menu-item-group",{attrs:{title:"分组2"}},[n("el-menu-item",{attrs:{index:"3-3"}},[e._v("选项3")])],1),e._v(" "),n("el-submenu",{attrs:{index:"3-4"}},[n("template",{slot:"title"},[e._v("选项4")]),e._v(" "),n("el-menu-item",{attrs:{index:"3-4-1"}},[e._v("选项4-1")])],2)],2)],1)],1),e._v(" "),n("el-container",[n("el-header",{staticStyle:{"font-size":"12px","border-bottom":"1px solid grey"}},[n("span",{staticStyle:{float:"right","padding-top":"20px"}},[n("el-dropdown",{attrs:{type:"primary"},on:{command:e.handlelLogout}},[n("i",{staticClass:"el-icon-setting",staticStyle:{"margin-right":"20px"}}),e._v(" "),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",[e._v("个人信息")]),e._v(" "),n("el-dropdown-item",[e._v("退出")])],1)],1),e._v(" "),n("a",{domProps:{textContent:e._s(e.$store.state.user.username)}})],1)]),e._v(" "),n("el-main",[n("el-table",{attrs:{data:e.tableData}},[n("el-table-column",{attrs:{prop:"date",label:"日期",width:"140"}}),e._v(" "),n("el-table-column",{attrs:{prop:"name",label:"姓名",width:"120"}}),e._v(" "),n("el-table-column",{attrs:{prop:"address",label:"地址"}})],1)],1)],1)],1)},staticRenderFns:[]};var w=n("VU/8")(_,h,!1,function(e){n("0OLz")},null,null).exports;o.default.use(a.a);var x=new a.a({routes:[{path:"/",name:"login",component:f},{path:"/login",name:"Login",component:f},{path:"/dashboard",name:"DashBoard",component:w}]}),b=n("bOdI"),y=n.n(b)()({},"SAVE_LOGIN_USER",function(e,t){e.user=t||{}});o.default.use(d.a);var F=new d.a.Store({state:{user:{}},actions:{saveUserInfo:function(e,t){var n=e.commit;e.state,n("SAVE_LOGIN_USER",t)}},mutations:y}),H=n("//Fk"),S=n.n(H),C=n("woOf"),$=n.n(C),k=n("mtWM"),O=n.n(k),R=n("mw3O"),L=n.n(R),P=n("zL8q"),T=n.n(P);O.a.defaults.baseURL="http://localhost:8035",O.a.defaults.headers.post["Content-Type"]="application/x-www-form-urlencoded",O.a.defaults.timeout=3e4,O.a.interceptors.request.use(function(e){return $()(e,{data:L.a.stringify(e.data)})},function(e){return S.a.reject(e)}),O.a.interceptors.response.use(function(e){return console.log("---net----\x3e",e),200!=e.status?(Object(P.Message)({message:""+e.data.message,type:"error",showClose:!0}),S.a.reject(e)):S.a.resolve(e.data)},function(e){return Object(P.Message)({message:"网络错误"+e,type:"error",showClose:!0}),S.a.reject(e)});var j=O.a;n("tvR6");o.default.use(T.a),o.default.prototype.$http=j,o.default.config.productionTip=!1,o.default.directive("focus",{inserted:function(e){e.focus()}}),new o.default({el:"#app",router:x,store:F,components:{App:s},template:"<App/>"})},ovje:function(e,t){},tvR6:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.ddce23011f594945fbc1.js.map