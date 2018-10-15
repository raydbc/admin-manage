<template>
  <div id="content" :style="{height: heightSize}" >
     <div class="login">
       <div class="normal-title">
          <a class="sign_in" @click="register=false">登录</a>
          <b style="color: #ea6f5a; font-weight: bold;">·</b>
          <a class="sign_up" @click="register=true" id="sign_up">注册</a>
        </div>
        <form class="loginForm">
          <div style="margin-top: 30px">
            <input v-model="loginForm.username" type="text" name="username" value="" placeholder="用户名" auto-complete="off" v-focus/>
            <p style="color: red;">{{accountHint}}</p>
          </div>
          <div style="margin-top:0px">
            <input v-model="loginForm.password"  type="password" name="password" value="" auto-complete="off" placeholder="密码"/>
            <p style="color: red;">{{pwdHint}}</p>
          </div>
          <div style="margin-top:0px" v-if="register===true">
            <input v-model="loginForm.repassword" @keyup.native.enter="onRegister"  type="password" name="password" value="" auto-complete="off" placeholder="确认密码"/>
            <p style="color: red;">{{rePwdHint}}</p>
          </div>
          <div class="btn" style="margin-top:20px">
            <button @click="onLogin" v-if="register===false" class="sign-in-button"  type="button">登录</button>
            <button @click="onRegister" v-if="register===true" class="sign-up-button"  type="button">注册</button>
          </div>
        </form>
     </div>
  </div>
</template>

<script>
import { mapActions } from 'vuex';
export default {
  name: 'login',
  data() {
    return {
      accountHint: '',
      pwdHint: '',
      rePwdHint: '',
      register: false,
      loginForm: {
        username: '',
        password: '',
        repassword: ''
      }
    }
  },
  methods: {
    ...mapActions(['saveUserInfo']),
    async onLogin() {
      if (this.loginForm.username && this.loginForm.password) {
        let requestData = {
          username: this.loginForm.username,
          password: this.loginForm.password
        };
        try {
          const response = await this.$http({
            method: 'post',
            url: `/admin/login?email=${this.loginForm.username}&passwordHash=${this.loginForm.password}`
          });
          if (response.code == 200) {
            this.$store.dispatch('saveUserInfo', requestData);
            this.$router.push('/dashboard');
          } else {
            this.$alert(`${response.message}`, '错误提示', { confirmButtonText: '知道了', type: 'error'});
          }
          console.log('****2***', response);
        } catch (error) {
          this.$alert(`网络错误${error}`, '操作失败', { confirmButtonText: '知道了', type: 'error'});
        }
      }
    },
    onRegister() {
      console.log('-----register------>', this.loginForm);
      if (!this.loginForm.username && this.loginForm.username.trim() == '') {
        this.accountHint = '账号不能为空';
      } else {
        this.accountHint = '';
      }
      if (!this.loginForm.password && this.loginForm.password.trim() == '') {
        this.pwdHint = '密码不能为空';
      } else {
        this.pwdHint = '';
      }
      if (!this.loginForm.repassword && this.loginForm.repassword.trim() == '') {
        this.rePwdHint = '请再次确认密码';
      } else {
        this.rePwdHint = '';
      }
      if (this.loginForm.password && this.loginForm.repassword){
        if (this.loginForm.password !== this.loginForm.repassword) {
          this.rePwdHint = '两次密码填写不一致';
        } else {
          this.rePwdHint = '';
        }
      }
      console.log('******', this.loginForm);
      if (!(this.accountHint === this.pwdHint === this.rePwdHint === '') ){
        this.handleRegister();
      }
    },
    async handleRegister() {
      try {
        const response = await this.$http({
          method: 'post',
          url: '/api/userRegist',
          data: this.loginForm
        });
        if (response.code == 200) {
          this.register = false;
          this.$alert(`${response.message}`, '成功提示', { confirmButtonText: '知道了', type: 'success'});
        } else {
          this.$alert(`${response.message}`, '错误提示', { confirmButtonText: '知道了', type: 'error'});
        }
        console.log('****2***', response);
      } catch (error) {
        this.$alert(`网络错误${error}`, '操作失败', { confirmButtonText: '知道了', type: 'error'});
      }
    }
  },
  computed: {
    heightSize: {
      get() {
        return window.screen.availHeight + 'px';
      }
    }
  }
}
</script>

<style lang="css">
#content {
  width: 100%;
  height: 100%;
  min-height: 700px;
  background-image:url(../assets/bg.png);
  background-repeat:no-repeat;
  background-size:100% 100%;
  position:relative;
  overflow: hidden;
}

.login {
  top:50%;
  left:50%;
  font-size: 14px;
  margin-top:-180px;
  margin-left:-200px;
  width:400px;
  height: 200px;
  border-radius:10px;
  position:absolute;
}

input {
    width: 60%;
    height: 40px;
    margin-bottom: 0;
    padding: 4px 12px 4px 35px;
    border: 1px solid #c8c8c8;
    border-radius: 4px;
    background: #f1f1f1;
    vertical-align: middle;
}

.sign_in, .sign_up {
  font-size: 32px;
  font-weight:bold;
  text-decoration: none;
  color: #faf9f9;
  font-family: -apple-system,SF UI Display,Arial,PingFang SC,Hiragino Sans GB,Microsoft YaHei,WenQuanYi Micro Hei,sans-serif;
}
.sign-in-button, .sign-up-button {
  width: 70%;
  height: 50px;
  padding: 9px 18px;
  font-size: 18px;
  border: none;
  border-radius: 5px;
  color: #fff;
  background: #42c02e;
  cursor: pointer;
  outline: none;
  clear: both;
}
a {
  cursor: pointer;
}
</style>
