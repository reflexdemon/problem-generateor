<template>
  <div class="problem-display">
    <v-card>
<v-card-text >
  <v-badge> {{timer}} </v-badge>
<div class="display-3 text-xs-right">{{response.firstNumber}}</div>
<div class="display-3 text-xs-right">{{response.operator}} {{response.secondNumber}}</div>
</v-card-text>
  <v-card-actions>
    <v-text-field reverse class="styled-input" height="120" type="number" name="answer" v-model="response.result"  autocomplete="off"/>
  </v-card-actions>
  <v-btn
              color="green"
              dark
              small
              absolute
              bottom
              right
              fab
              @click="$vuetify.goTo(0)"
            >
              <v-icon>arrow_upward</v-icon>
            </v-btn>
</v-card>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from 'vue-class-component'
const ProblemDisplayProps = Vue.extend({
  props: {
    response: Object,
    timer: String
  }
})
@Component
export default class ProblemDisplay extends ProblemDisplayProps {
  sampleStructureForResponse = {
    firstNumber: Number,
    secondNumber: Number,
    answer: Number,
    result: Number,
    operator: String
  };
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.styled-input {
     font-size:40px;
  /* position:absolute; */
  width:100%;
  top:50%;
  -webkit-transform:translateY(-50%);
  left:0;
  outline:none;
}

</style>
