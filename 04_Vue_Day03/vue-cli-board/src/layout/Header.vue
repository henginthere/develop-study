<template>
  <header>
    <nav>
      <ul>
        <li>
          <router-link to="/">홈</router-link>
        </li>
        <li>
          <router-link to="/list">게시판</router-link>
        </li>
      </ul>
    </nav>
  </header>
</template>

<script>
export default {
  name: 'AppHeader',
};
</script>
