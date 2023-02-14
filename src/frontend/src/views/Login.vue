<template>
    <v-container style="max-width:1300px" fill-height>
        <v-layout align-center row wrap>
            <v-row>
                <v-col cols="4"></v-col>
                <v-col cols="4">
                    <v-card elevation="12" width="350" height="460" style="border-radius:25px; border: 1px solid #008037">
                        <v-img :src="require('../../images/WhatSuWhite.png')" max-height="110" max-width="110" style="margin: 1em auto;" class="mb-0"></v-img>
                        <div style="text-align: center; color:#008037; font-size:xx-large; font-family: 'KOTRA_BOLD';" class="mt-0">로그인</div>
                        <v-card-text class="pt-3 pb-0 mb-0">
                            <v-text-field v-model="id" :rules="id_rules"  label="아이디" prepend-inner-icon="mdi-account" color="#008037">
                            </v-text-field>
                            <v-text-field v-model="password" :rules="password_rules" label="비밀번호" type="password" prepend-inner-icon="mdi-lock" color="#008037">
                            </v-text-field>
                        </v-card-text>
                        <v-card-actions class="py-0 mt-0">
                            <v-spacer></v-spacer>
                            <v-btn class="font-weight-bold body-2" plain @click="onClickFind('/idfind')">아이디 찾기</v-btn>
                            <v-btn class="font-weight-bold body-2" plain @click="onClickFind('/pwfind')">비밀번호 찾기</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                        <v-card-actions>
                            <v-btn style="border-radius: 30px;" elevation="2" type="submit" color="#008037" text-capitalize depressed block dark @click="onClickLogin">
                                로그인
                            </v-btn>
                        </v-card-actions>
                        <v-card-actions>
                            <v-btn style="border-radius:30px; border: 1px solid #008037" elevation="2" type="submit"  text-capitalize depressed block @click="onClickJoin"">
                                회원가입
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-col>
            </v-row>
        </v-layout>
    </v-container>
</template>
<script>
import * as appx from '../store/modules/app'
import * as app_types from '../store/modules/app/types'

(function(){var w=window;if(w.ChannelIO){return w.console.error("ChannelIO script included twice.")}var ch=function(){ch.c(arguments)};ch.q=[];ch.c=function(args){ch.q.push(args)};w.ChannelIO=ch;function l(){if(w.ChannelIOInitialized){return}w.ChannelIOInitialized=true;var s=document.createElement("script");s.type="text/javascript";s.async=true;s.src="https://cdn.channel.io/plugin/ch-plugin-web.js";var x=document.getElementsByTagName("script")[0];if(x.parentNode){x.parentNode.insertBefore(s,x)}}if(document.readyState==="complete"){l()}else{w.addEventListener("DOMContentLoaded",l);w.addEventListener("load",l)}})();

  ChannelIO('boot', {
    "pluginKey": "a7995c55-0012-40ed-a6d7-f2e3945d6a90"
  });

export default {
    name: "login",
    data: () => ({
      id_rules: [
          v => !!v || '아이디를 입력해 주세요'
      ],
      password_rules: [
        v => !!v || '패스워드를 입력해 주세요'
      ],
      id: '',
      password: ''
    }),
  methods: {
      ...appx.mapMutations([app_types.SET_USER_INFO, app_types.LOGOUT]),
      onClickLogin: function () {
        if (this.id === 'admin' && this.password === 'admin') {
          this.SET_USER_INFO({ is_admin: true })
          this.$router.push('/')
        }

        if (this.user.id === 'user' && this.password === 'password') {
          this.SET_USER_INFO({ is_admin: false })
          this.$router.push('/')
        }
      },
    onClickJoin: function () {
        this.$router.push('/signup')
    },
    onClickFind: function (path) {
        this.$router.push(path)
    }
  },
  computed: {
      ...appx.mapState(['user', 'is_login']),
    app_user: {
        get() {
          return this.user
        }
    }
  },

  beforeMount() {
      if (this.is_login) {
        this.LOGOUT()
      }
  }
}
</script>