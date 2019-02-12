<template>
  <v-app id="inspire" dark>
    <v-navigation-drawer
      v-model="drawer"
      clipped
      fixed
      app
    >
      <v-list dense>
        <v-list-tile @click="callback"
              v-for="item in menu"
              :key="item.$index"
              :to="item.to">
          <v-list-tile-action>
            <v-icon>{{item.icon}}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>{{item.label}}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar app fixed clipped-left>
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <v-toolbar-title>VPV Math Puzzles</v-toolbar-title>
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
        &copy;{{new Date().getFullYear()}} - <strong> <a href="https://me.vpv.io">Venkateswara VP</a> </strong>

    </v-layout>
  </v-footer>
  </v-app>
</template>

<script>
export default {
  data: () => ({
    drawer: null,
    menu: [ {
      to: '/',
      icon: 'home',
      label: 'Home'
    },
    {
      to: '/add',
      icon: 'add',
      label: 'Add'
    },
    {
      to: '/about',
      icon: 'info',
      label: 'About'
    }
    ]
  }),
  props: {
    source: String
  },

  methods: {
    callback: function () {

    }
  }
}
</script>
