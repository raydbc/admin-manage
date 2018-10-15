const SAVE_LOGIN_USER = 'SAVE_LOGIN_USER'


export default {
  [SAVE_LOGIN_USER](state, data) {
    state.user = data || {};
  }
}
