<template>
  <a-layout>
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          v-model:selectedKeys="selectedKeys2"
          v-model:openKeys="openKeys"
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
      >
        <a-sub-menu key="sub1">
          <template #title>
              <span>
                <user-outlined />
                subnav 1111
              </span>
          </template>
          <a-menu-item key="1">option1</a-menu-item>
          <a-menu-item key="2">option2</a-menu-item>
          <a-menu-item key="3">option3</a-menu-item>
          <a-menu-item key="4">option4</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub2">
          <template #title>
              <span>
                <laptop-outlined />
                subnav 2
              </span>
          </template>
          <a-menu-item key="5">option5</a-menu-item>
          <a-menu-item key="6">option6</a-menu-item>
          <a-menu-item key="7">option7</a-menu-item>
          <a-menu-item key="8">option8</a-menu-item>
        </a-sub-menu>
        <a-sub-menu key="sub3">
          <template #title>
              <span>
                <notification-outlined />
                subnav 3
              </span>
          </template>
          <a-menu-item key="9">option9</a-menu-item>
          <a-menu-item key="10">option10</a-menu-item>
          <a-menu-item key="11">option11</a-menu-item>
          <a-menu-item key="12">option12</a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <pre>
{{ebooks}}
<!--{{ebooks2}}-->
      </pre>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent , onMounted , ref , reactive , toRef} from 'vue'; // @ is an alias to /src
import axios from 'axios';

export default defineComponent({
  name: 'Home',
  setup() {
    console.log("setup");
    const ebooks = ref();  //ref  和  reactive , toRef使用二选一
    // const ebooks1 = reactive({books : []});

    onMounted(() => {
      console.log("onMounted");
      axios.get("http://localhost:8880/ebook/list?name=spring").then(function (response) {
        const data = response.data;
        //value出错，表示TypeScript版本过低，然后刷新TypeScript重启服务
        //项目内安装TypeScript 查看版本npx tsc --version   全局内安装TypeScript 查看版本tsc --version
        ebooks.value = data.content;
        //data.content查出来的内容实际是一个数组
        // ebooks1.books = data.content;
        console.log(response);
      });
    });
    return{
      ebooks,
      // ebooks2 : toRef(ebooks1, "books")
    }
  }
});
</script>
