<template>
  <v-app id="inspire" :dark="theme">
    <v-navigation-drawer
      v-model="drawer"
      clipped
      fixed
      app
    >
      <v-list dense>
        <span v-for="item in menu"
              :key="item.$index">
        <v-list-tile @click="callback" v-if="item.to" :to="item.to">
          <v-list-tile-action>
            <v-icon>{{item.icon}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{item.label}}</v-list-tile-title>
            </v-list-tile-content>
        </v-list-tile>
        <v-list-tile @click="callback" v-else :href="item.href" :target="item.target">
          <v-list-tile-action>
            <v-icon>{{item.icon}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{item.label}}</v-list-tile-title>
            </v-list-tile-content>
        </v-list-tile>
        </span>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar app fixed clipped-left>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>VPV Math Puzzles</v-toolbar-title>
      <v-spacer></v-spacer>
<v-btn-toggle v-model="theme">
        <v-btn :value="true" flat>
          <v-icon>toggle_on</v-icon>
        </v-btn>
       </v-btn-toggle>
    <v-btn round href="/signin" v-if="!user.id">
      <v-icon>account_circle</v-icon> Sign in
    </v-btn>
    <span v-else>
      <v-chip close v-model="chip">
            <v-avatar v-if="user.avatarUrl">
              <img :src="user.avatarUrl" :alt="user.firstName">
            </v-avatar>
            <v-icon v-else color="green">account_circle</v-icon>
            {{user.firstName}}
          </v-chip>
    </span>
    </v-toolbar>
    <v-content>
      <router-view/>
    </v-content>
    <v-footer app fixed>
      <span class="text-center">

        </span>
    </v-footer>
    <v-footer
    height="auto"
    app fixed
  >
    <v-layout
      justify-center
      row
      wrap
    >
        &copy; {{new Date().getFullYear()}} - <strong> <a href="https://me.vpv.io">Venkateswara VP</a> </strong>

    </v-layout>
  </v-footer>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from 'vue-class-component'

const AppProps = Vue.extend({
  props: {
    source: String
  }
})

@Component
export default class App extends AppProps {
  drawer= null;
  chip=true;
  theme=true;
  signOutMenuItem = {
    href: '/logout',
    icon: 'account_circle',
    label: 'Sign Out'
  };
  signInMenuItem = {
    href: '/signin',
    icon: 'account_circle',
    label: 'Sign In'
  };
  mainmenu = [ {
    to: '/',
    icon: 'home',
    label: 'Home'
  },
  {
    to: '/add',
    icon: 'add',
    label: 'Addition'
  },
  {
    to: '/sub',
    icon: 'remove',
    label: 'Subtract'
  },
  {
    to: '/mul',
    icon: 'clear',
    label: 'Multiply'
  },
  {
    to: '/div',
    icon: 'share',
    label: 'Divide'
  },
  {
    to: '/about',
    icon: 'info',
    label: 'About'
  },
  {
    href: 'https://github.com/reflexdemon/problem-generateor',
    icon: 'link',
    label: 'Source Code',
    target: '_blank'
  }
  ];
  menu:any = [];
  user = {
    id: null,
    username: null,
    email: null,
    source: null,
    firstName: null,
    lastName: null,
    avatarUrl: null,
    profileUrl: null
  };

  created () {
    this.getUser()
  }

  callback () {

  }
  buildMenu () {
    this.mainmenu.forEach(item => this.menu.push(item))
    if (this.user.id) {
      this.menu.push(this.signOutMenuItem)
    } else {
      this.menu.push(this.signInMenuItem)
    }
  }
  getUser () {
    fetch('/api/user')
      .then(response => response.json())
      .then(this.onUserInfo.bind(this))
      .catch(this.errorHandler.bind(this))
  }

  onUserInfo (data:any) {
    console.log('User:', data)
    if (data && data.id) {
      this.user = data
    }
    this.buildMenu()
  }

  errorHandler (err:any) {
    console.log('User is not available', err)
    this.buildMenu()
  }
}
</script>
