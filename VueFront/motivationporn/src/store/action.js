
/*
和后台交互的action
 */
import {reqRandomPorn} from '../api/index'
import {RECEIVE_RANDOM_PORN} from './mutations-type'

export default {
  // 异步获取
  // action可以传递 state，也可以不传。可以接收前台的参数
  async getRandomPorn ({commit}) {
    const result = await reqRandomPorn()
    console.log('read data is ' + result)
    // 参数必须是{}对象
    commit(RECEIVE_RANDOM_PORN, {porn: result.data.content})
  }
}
