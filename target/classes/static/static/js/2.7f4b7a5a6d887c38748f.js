webpackJsonp([2],{Rm9S:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("yqhJ"),l=(a("p18z"),{name:"addArticle",data:function(){return{value2:!1,categoryList:[],article:{c_id:"",title:"",keyword:"",describe:"",picture:"",markdown:"",html:"",hot:"",text:""},fileList:[{name:"原图片",url:""}],headers:{token:this.$store.getters.token},initData:"initData"}},components:{Markdown:s.a},created:function(){this.headers.token=this.$store.getters.token,this.article=this.$router.currentRoute.params,this.fileList[0].url=this.article.picture,this.initData=this.article.markdown,"1"==this.article.hot&&(this.value2=!0),this.findByCategoryAll()},methods:{findByCategoryAll:function(t,e){var a=this;this.$axios({method:"get",url:this.$baseURL+"/articleCategory/findByAll",headers:{"Content-Type":"application/json;charset=UTF-8",token:this.$store.getters.token}}).then(function(t){console.log(t),a.categoryList=t.data}).catch(function(t){console.log(t)})},uploadSuccess:function(t,e,a){return console.log(t,e,a),t.ok?(this.article.picture=t.data.src,this.$message({showClose:!0,message:"上传成功！",type:"success"})):(this.fileList=[],console.log("resp失败onse",a),this.$message({showClose:!0,message:"上传失败！",type:"error"})),!1},uploadError:function(t,e,a){return console.log(t,e,a),this.$message({showClose:!0,message:"上传失败！",type:"error"}),!1},change:function(){this.article.markdown=arguments[0].markdown,this.article.html=arguments[0].html,this.article.text=arguments[0].text},querySearch:function(t,e){var a=this.restaurants;e(t?a.filter(this.createFilter(t)):a)},createFilter:function(t){return function(e){return 0===e.value.toLowerCase().indexOf(t.toLowerCase())}},handleSelect:function(t){console.log(t)},submitArticle:function(){var t=this;this.value2?this.article.hot="1":this.article.hot="0",this.$axios({method:"put",url:this.$baseURL+"/article/updateById",data:this.article,headers:{"Content-Type":"application/json;charset=UTF-8",token:this.$store.getters.token}}).then(function(e){console.log(e),e.data.ok?(t.$message({showClose:!0,message:e.data.message,type:"success"}),t.findPage(t.page.pageNum,t.pageSize)):t.$message({showClose:!0,message:e.data.message,type:"error"})}).catch(function(t){console.log(t)}),console.log("源码",this.article)}}}),i={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"addArticle"},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-upload",{staticClass:"upload-demo",attrs:{drag:"","list-type":"picture",limit:1,action:t.$baseURL+"/upload/uploadFileMasterGraph",headers:t.headers,multiple:"","file-list":t.fileList,"on-success":t.uploadSuccess,"on-error":t.uploadError}},[a("i",{staticClass:"el-icon-upload"}),t._v(" "),a("div",{staticClass:"el-upload__text"},[t._v("\n          将\n          "),a("span",{staticStyle:{color:"red"}},[t._v("主图")]),t._v("拖到此处，或\n          点击上传\n          "),a("p",{staticStyle:{color:"#005aff"}},[t._v("建议图片比例统一")])])])],1),t._v(" "),a("el-col",{attrs:{span:16}},[a("el-form",{ref:"article",attrs:{model:t.article,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"文章标题"}},[a("el-input",{attrs:{placeholder:"50字符内",maxlength:"50"},model:{value:t.article.title,callback:function(e){t.$set(t.article,"title",e)},expression:"article.title"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"文章描述"}},[a("el-input",{attrs:{placeholder:"100字符内",maxlength:"100"},model:{value:t.article.intro,callback:function(e){t.$set(t.article,"intro",e)},expression:"article.intro"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"关键字"}},[a("el-input",{staticClass:"keyword",attrs:{placeholder:"3-5个关键字（关键字与关键字之间用英文逗号隔开）",maxlength:"80"},model:{value:t.article.keyword,callback:function(e){t.$set(t.article,"keyword",e)},expression:"article.keyword"}}),t._v(" "),a("el-select",{staticClass:"articleCategory",attrs:{placeholder:"请选择所属文章类别"},model:{value:t.article.c_id,callback:function(e){t.$set(t.article,"c_id",e)},expression:"article.c_id"}},t._l(t.categoryList,function(t){return a("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})}),1),t._v(" "),a("el-switch",{staticClass:"hot",staticStyle:{display:"block"},attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":"首页展示"},model:{value:t.value2,callback:function(e){t.value2=e},expression:"value2"}}),t._v(" "),a("el-button",{staticClass:"subBtn",attrs:{type:"primary"},on:{click:t.submitArticle}},[t._v("修改")])],1)],1)],1)],1),t._v(" "),a("Markdown",{attrs:{onchange:t.change,initData:t.initData}})],1)},staticRenderFns:[]};var r=a("C7Lr")(l,i,!1,function(t){a("cKL6")},null,null);e.default=r.exports},cKL6:function(t,e){}});
//# sourceMappingURL=2.7f4b7a5a6d887c38748f.js.map