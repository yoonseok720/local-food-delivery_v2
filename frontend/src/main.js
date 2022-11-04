 /*eslint-disable*/
import Vue from "vue";
import App from "./App.vue";
import vuetify from "./plugins/vuetify";
import Managing from "./components";
import router from './router';
Vue.config.productionTip = false;

const axios = require("axios").default;

// backend host url
axios.backend = null; //"http://localhost:8088";

// axios.backendUrl = new URL(axios.backend);
axios.fixUrl = function(original){

  if(!axios.backend && original.indexOf("/")==0) return original;

  var url = null;

  try{
    url = new URL(original);
  }catch(e){
    url = new URL(axios.backend + original);
  }

  if(!axios.backend) return url.pathname;

  url.hostname = axios.backendUrl.hostname;
  url.port = axios.backendUrl.port;

  return url.href;
}

const templateFiles = require.context("./components", true);
Vue.prototype.$ManagerLists = [];
templateFiles.keys().forEach(function(tempFiles) {
  if (!tempFiles.includes("Manager.vue") && tempFiles.includes("vue")) {
    Vue.prototype.$ManagerLists.push(
      tempFiles.replace("./", "").replace(".vue", "")
    );
  }
});
Vue.use(Managing);
const pluralCaseList = []

pluralCaseList.push( {plural: "주문", pascal: "주문"} )
pluralCaseList.push( {plural: "orders", pascal: "Order"} )

pluralCaseList.push( {plural: "메뉴판", pascal: "메뉴판"} )
pluralCaseList.push( {plural: "통합주문상태", pascal: "통합주문상태"} )
pluralCaseList.push( {plural: "결제이력", pascal: "결제이력"} )
pluralCaseList.push( {plural: "payments", pascal: "Payment"} )

pluralCaseList.push( {plural: "주문관리", pascal: "주문관리"} )
pluralCaseList.push( {plural: "orders", pascal: "Order"} )

pluralCaseList.push( {plural: "주문상세보기", pascal: "주문상세보기"} )


pluralCaseList.push( {plural: "orderLists", pascal: "OrderList"} )

Vue.prototype.$ManagerLists.forEach(function(item, idx) {
  pluralCaseList.forEach(function(tmp) {
    if(item.toLowerCase() == tmp.pascal.toLowerCase()) {
      var obj = {
        name: item,
        plural: tmp.plural
      }
      Vue.prototype.$ManagerLists[idx] = obj
    }
  })
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount("#app");
