import ajax from './ajax'

const BASE_URL = '/api'

export const reqRandomPorn = () => ajax(BASE_URL + '/porn/random')
