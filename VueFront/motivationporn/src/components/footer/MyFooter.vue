<template>
  <div class="my-footer" style="background-color: bisque">
    <Row style="background-color: snow">
      <Col>
        <Button shape="circle" size="large" type="primary">截图分享</Button>
      </Col>
      <Col>
        <Row>
          <Col span="12"><span style="text-align: right; background-color: snow">本网站仿 <a href="http://www.nows.fun/">http://www.nows.fun/</a> </span></Col>
          <Col span="12"><span style="text-align: left; background-color: snow">开源：https://github.com/xxx/xxxxx</span></Col>
        </Row>
      </Col>
    </Row>
  </div>
</template>

<script>
export default {
  name: 'MyFooter'
}
</script>

<style scoped>

  .my-footer {
    background-color: snow;
  }

  button {
    width: 160px;
    height: 60px;
    border: 1px #444444;
    background-color: #444444;
    color: aliceblue;
    font-size: 20px;
    box-shadow: 0 0 0 #444444;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: bold;
  }

  button:hover {
    box-shadow: 0 0 10px #444444;
    background-color: #444444;
  }
</style>
