<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>Essential Links</h2>
    <Collapse/>
  </div>
</template>

<script>

import Collapse from './test/Collapse'

export default {
  name: 'Main',
  components: {
    Collapse
  },
  data () {
    return {
      msg: '毒鸡汤来一碗'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
