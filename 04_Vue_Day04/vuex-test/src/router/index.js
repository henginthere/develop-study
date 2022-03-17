import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Step00 from "../views/Step00.vue";
import Step01 from "../views/Step01.vue";
import Step02 from "../views/Step02.vue";
import Step03 from "../views/Step03.vue";
import Step04 from "../views/Step04.vue";
import Step05 from "../views/Step05.vue";
import Step06 from "../views/Step06.vue";
import Step07 from "../views/Step07.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/step00",
    name: "Step00",
    component: Step00,
  },
  {
    path: "/step01",
    name: "Step01",
    component: Step01,
  },
  {
    path: "/step02",
    name: "Step02",
    component: Step02,
  },
  {
    path: "/step03",
    name: "Step03",
    component: Step03,
  },
  {
    path: "/step04",
    name: "Step04",
    component: Step04,
  },
  {
    path: "/step05",
    name: "Step05",
    component: Step05,
  },
  {
    path: "/step06",
    name: "Step06",
    component: Step06,
  },
  {
    path: "/step07",
    name: "Step07",
    component: Step07,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
