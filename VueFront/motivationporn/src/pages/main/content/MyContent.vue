<template>
  <div class="my-content">

    <Row type="flex" justify="center" align="middle" class="code-row-bg">
      <Col span="24" style="height: 100%">
        <span id="sentence">{{porn}}</span>
      </Col>
    </Row>
  </div>
</template>

<script>
export default {
  name: 'MyContent',
  data () {
    return {
      porn: '不管是白帽子，还是黑帽子，会变绿的都不是好帽子。'
    }
  }
}
</script>

<style scoped>

  .code-row-bg{
    height: 100%;
  }
  #sentence{
    font-size: 2rem;
    color: #444444;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: bold;
  }
  .my-content{
    width: 100%;
    position: absolute;
    top: 30%;
    bottom: 0px;
    left: 0px;
  }
</style>
