webpackJsonp([5],{aYF5:function(e,t){},tbhn:function(e,t,s){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var a={name:"addArticle",data:function(){return{entity:{},fileList:[{name:"LOGO",url:""}],fileList1:[{name:"favicon",url:""}],fileList2:[{name:"favicon",url:""}],headers:{token:this.$store.getters.token}}},created:function(){this.findById(1)},methods:{findById:function(e){var t=this;this.$axios({method:"get",url:this.$baseURL+"/company/find",headers:{"Content-Type":"application/json;charset=UTF-8",token:this.$store.getters.token}}).then(function(e){console.log(e),t.entity=e.data,t.fileList[0].url=t.entity.logo,t.fileList1[0].url=t.entity.favicon,t.fileList2[0].url=t.entity.qrcode}).catch(function(e){console.log(e)})},uploadSuccess:function(e,t,s){return console.log(e,t,s),e.ok?(this.entity.logo=e.data.src,this.$message({showClose:!0,message:"上传成功！",type:"success"})):(this.fileList=[],console.log("resp失败onse",s),this.$message({showClose:!0,message:"上传失败！",type:"error"})),!1},uploadSuccess2:function(e,t,s){return console.log(e,t,s),e.ok?(this.entity.qrcode=e.data.src,this.$message({showClose:!0,message:"上传成功！",type:"success"})):(this.fileList=[],console.log("resp失败onse",s),this.$message({showClose:!0,message:"上传失败！",type:"error"})),!1},uploadSuccess1:function(e,t,s){return console.log(e,t,s),e.ok?(this.entity.favicon=e.data.src,this.$message({showClose:!0,message:"上传成功！",type:"success"})):(this.fileList1=[],console.log("resp失败onse",s),this.$message({showClose:!0,message:"上传失败！",type:"error"})),!1},uploadError:function(e,t,s){return console.log(e,t,s),this.$message({showClose:!0,message:"上传失败！",type:"error"}),!1},submitArticle:function(){var e=this;this.$axios({method:"put",url:this.$baseURL+"/company/updateById",data:this.entity,headers:{"Content-Type":"application/json;charset=UTF-8",token:this.$store.getters.token}}).then(function(t){console.log(t),t.data.ok?(e.$message({showClose:!0,message:t.data.message,type:"success"}),e.findPage(e.page.pageNum,e.pageSize)):e.$message({showClose:!0,message:t.data.message,type:"error"})}).catch(function(e){console.log(e)}),console.log("源码",this.entity)}}},l={render:function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"company"},[s("el-row",[s("el-col",{attrs:{span:6}},[s("el-upload",{staticClass:"upload-demo",attrs:{drag:"","list-type":"picture",limit:1,action:e.$baseURL+"/upload/uploadFileMasterGraph",headers:e.headers,multiple:"","file-list":e.fileList,"on-success":e.uploadSuccess,"on-error":e.uploadError}},[s("i",{staticClass:"el-icon-upload"}),e._v(" "),s("div",{staticClass:"el-upload__text"},[e._v("\n          将\n          "),s("span",{staticStyle:{color:"red"}},[e._v("LOGO")]),e._v("拖到此处，或\n          点击上传\n          "),s("p",{staticStyle:{color:"#005aff"}},[e._v("建议468*60")])])])],1),e._v(" "),s("el-col",{attrs:{span:6}},[s("el-upload",{staticClass:"upload-demo",attrs:{drag:"","list-type":"picture",limit:1,action:e.$baseURL+"/upload/uploadFileMasterGraph",headers:e.headers,multiple:"","file-list":e.fileList1,"on-success":e.uploadSuccess1,"on-error":e.uploadError}},[s("i",{staticClass:"el-icon-upload"}),e._v(" "),s("div",{staticClass:"el-upload__text"},[e._v("\n          将\n          "),s("span",{staticStyle:{color:"red"}},[e._v("favicon")]),e._v("拖到此处，或\n          点击上传\n          "),s("p",{staticStyle:{color:"#005aff"}},[e._v("建议64*64")])])])],1),e._v(" "),s("el-col",{attrs:{span:6}},[s("el-upload",{staticClass:"upload-demo",attrs:{drag:"","list-type":"picture",limit:1,action:e.$baseURL+"/upload/uploadFileMasterGraph",headers:e.headers,multiple:"","file-list":e.fileList2,"on-success":e.uploadSuccess2,"on-error":e.uploadError}},[s("i",{staticClass:"el-icon-upload"}),e._v(" "),s("div",{staticClass:"el-upload__text"},[e._v("\n          将\n          "),s("span",{staticStyle:{color:"red"}},[e._v("二维码")]),e._v("拖到此处，或\n          点击上传\n        ")])])],1),e._v(" "),s("el-col",{attrs:{span:6}},[s("el-button",{staticClass:"subBtn",attrs:{type:"primary"},on:{click:e.submitArticle}},[e._v("提交")])],1)],1),e._v(" "),s("br"),e._v(" "),s("el-form",{ref:"entity",attrs:{model:e.entity,"label-width":"80px"}},[s("el-form-item",{attrs:{label:"企业名称"}},[s("el-input",{attrs:{maxlength:"100"},model:{value:e.entity.name,callback:function(t){e.$set(e.entity,"name",t)},expression:"entity.name"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"企业地址"}},[s("el-input",{attrs:{maxlength:"200"},model:{value:e.entity.address,callback:function(t){e.$set(e.entity,"address",t)},expression:"entity.address"}})],1),e._v(" "),s("el-form",{ref:"entity",attrs:{model:e.entity,"label-width":"80px"}},[s("el-form-item",{attrs:{label:"网站域名"}},[s("el-input",{attrs:{maxlength:"100"},model:{value:e.entity.url,callback:function(t){e.$set(e.entity,"url",t)},expression:"entity.url"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"邮箱"}},[s("el-input",{attrs:{maxlength:"50"},model:{value:e.entity.email,callback:function(t){e.$set(e.entity,"email",t)},expression:"entity.email"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"电话"}},[s("el-input",{attrs:{maxlength:"11"},model:{value:e.entity.phone,callback:function(t){e.$set(e.entity,"phone",t)},expression:"entity.phone"}})],1)],1),e._v(" "),s("el-form-item",{attrs:{label:"版权信息"}},[s("el-input",{attrs:{maxlength:"200"},model:{value:e.entity.copyright,callback:function(t){e.$set(e.entity,"copyright",t)},expression:"entity.copyright"}})],1)],1)],1)},staticRenderFns:[]};var o=s("C7Lr")(a,l,!1,function(e){s("aYF5")},null,null);t.default=o.exports}});
//# sourceMappingURL=5.64e48d170337cfbe1b36.js.map