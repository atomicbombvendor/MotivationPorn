<template>
  <Layout>
    <Header class="header">
      <MyHeader/>
    </Header>
    <Content class="content">
      <MyContent/>
    </Content>
    <Footer class="footer">
      <MyFooter/>
    </Footer>
  </Layout>
</template>

<script>

import MyHeader from '../../components/header/MyHeader'
import MyFooter from '../../components/footer/MyFooter'
import MyContent from './content/MyContent'

export default {
  name: 'Main',
  components: {
    MyHeader,
    MyFooter,
    MyContent
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
  .header{
    background-color: snow;
    height: 120px;
    position: relative; width: 100%; z-index: 999
  }

  .content{
    /*position: absolute; top: 120px; width: 100%; height: 100%;*/
    /*height: 100%;*/
    /*min-height: 100%; !* 至少撑满屏幕，万一文章内容比较长也可自动延伸 *!*/
    /*margin-top: 0;*/
    /*margin-bottom: 0; !* 页面开始已经100%，margin 会导致初始状态即超出屏幕 *!*/
    /*padding-top: 0;*/
    /*padding-bottom: 0; !* 这两条根据盒模型取舍，我司该处是 standard mode，同 margin 理由设为0 *!*/
    /*overflow-y: scroll; !* 一单文章超出初始区域，如果不能滚动就悲剧了 *!*/

    width: 100%;
    position: absolute;
    top: 120px;
    bottom: 0px;
    left: 0px;
  }

  .footer{
    position: absolute; bottom: 7vh; width: 100%;
    background-color: snow;
  }

  .header .content .footer{
    background-color: snow;
  }

</style>
