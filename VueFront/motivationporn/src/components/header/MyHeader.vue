<template>
    <Row type="flex" justify="center" align="middle" class="my-header">
      <Col span="6" style="height: 82px">
        <img alt="Logo" src="../../assets/log_3_130_82.png">
      </Col>
      <Col offset="12" span="6">
        <Button type="primary" size="large" shape="circle">再来一碗</Button>
      </Col>
    </Row>
</template>

<script>

export default {
  name: 'MyHeader',
  data () {
    return {
      LOGO: './images/log_1.png'
    }
  }
}
</script>

<style scoped>
  .my-header{
    padding-top: 20px;
  }
  button{
    width: 100px;
    height: 40px;
    border: 1px #444444;
    background-color: #444444;
    color: aliceblue;
    font-size: 15px;
    box-shadow: 0 0 0 #444444;
  }
  button:hover{
    box-shadow: 0 0 10px #444444;
    background-color: #444444;
  }
</style>
