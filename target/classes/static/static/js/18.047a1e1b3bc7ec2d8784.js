webpackJsonp([18],{"8al6":function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("yqhJ"),l=a("p18z"),o={name:"addArticle",data:function(){return{value2:!1,fileList:[],categoryList:[],article:{title:"",keyword:"",intro:"",picture:"",markdown:"",hot:"",html:"",text:""},headers:{token:this.$store.getters.token},initData:l.a}},components:{Markdown:s.a},created:function(){},methods:{uploadSuccess:function(e,t,a){return console.log(e,a),e.ok?(this.article.picture=e.data.src,this.$message({showClose:!0,message:"上传成功！",type:"success"})):(this.fileList=[],console.log("resp失败onse",a),this.$message({showClose:!0,message:"上传失败！",type:"error"})),!1},uploadError:function(e,t,a){return console.log(e,t,a),this.$message({showClose:!0,message:"上传失败！",type:"error"}),!1},change:function(){console.log("编辑",arguments[0]),this.article.markdown=arguments[0].markdown,this.article.html=arguments[0].html,this.article.text=arguments[0].text},querySearch:function(e,t){var a=this.restaurants;t(e?a.filter(this.createFilter(e)):a)},createFilter:function(e){return function(t){return 0===t.value.toLowerCase().indexOf(e.toLowerCase())}},handleSelect:function(e){console.log(e)},submitArticle:function(){var e=this;for(var t in console.log(this.article),this.value2?this.article.hot="1":this.article.hot="0",this.article)if(""==this.article[t]||null==this.article[t])return void this.$message({showClose:!0,message:"请填写全部信息，不能为空！",type:"error"});this.$axios({method:"post",url:this.$baseURL+"/about/add",data:this.article,headers:{"Content-Type":"application/json;charset=UTF-8",token:this.$store.getters.token}}).then(function(t){console.log(t),t.data.ok?(e.$message({showClose:!0,message:t.data.message,type:"success"}),e.findPage(e.page.pageNum,e.pageSize)):e.$message({showClose:!0,message:t.data.message,type:"error"})}).catch(function(e){console.log(e)}),console.log("源码",this.article)}},mounted:function(){}},i={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"addArticle"},[a("el-row",[a("el-col",{attrs:{span:8}},[a("el-upload",{staticClass:"upload-demo",attrs:{drag:"","list-type":"picture",fileList:e.fileList,limit:1,action:e.$baseURL+"/upload/uploadFileMasterGraph",headers:e.headers,"on-success":e.uploadSuccess,"on-error":e.uploadError,multiple:""}},[a("i",{staticClass:"el-icon-upload"}),e._v(" "),a("div",{staticClass:"el-upload__text"},[e._v("\n          将\n          "),a("span",{staticStyle:{color:"red"}},[e._v("主图")]),e._v("拖到此处，或\n          点击上传\n          "),a("p",{staticStyle:{color:"#005aff"}},[e._v("建议图片比例统一")])])])],1),e._v(" "),a("el-col",{attrs:{span:16}},[a("el-form",{ref:"article",attrs:{model:e.article,"label-width":"80px"}},[a("el-form-item",{attrs:{label:"文章标题"}},[a("el-input",{attrs:{placeholder:"50字符内",maxlength:"50"},model:{value:e.article.title,callback:function(t){e.$set(e.article,"title",t)},expression:"article.title"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"文章描述"}},[a("el-input",{attrs:{placeholder:"500字符内",maxlength:"500"},model:{value:e.article.intro,callback:function(t){e.$set(e.article,"intro",t)},expression:"article.intro"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"关键字"}},[a("el-input",{staticClass:"keyword",attrs:{placeholder:"3-5个关键字（关键字与关键字之间用英文逗号隔开）",maxlength:"80"},model:{value:e.article.keyword,callback:function(t){e.$set(e.article,"keyword",t)},expression:"article.keyword"}}),e._v(" "),a("el-switch",{staticClass:"hot",staticStyle:{display:"block"},attrs:{"active-color":"#13ce66","inactive-color":"#ff4949","active-text":"首页展示"},model:{value:e.value2,callback:function(t){e.value2=t},expression:"value2"}}),e._v(" "),a("el-button",{staticClass:"subBtn",attrs:{type:"primary"},on:{click:e.submitArticle}},[e._v("发布")])],1)],1)],1)],1),e._v(" "),a("Markdown",{attrs:{onchange:e.change,initData:e.initData}})],1)},staticRenderFns:[]};var r=a("C7Lr")(o,i,!1,function(e){a("fhqs")},null,null);t.default=r.exports},fhqs:function(e,t){}});
//# sourceMappingURL=18.047a1e1b3bc7ec2d8784.js.map