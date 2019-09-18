import {RECEIVE_RANDOM_PORN} from './mutations-type'

/*
  负责给State赋值
 */
export default {

  [RECEIVE_RANDOM_PORN] (state, {porn}) {
    state.porn = porn
  }
}
