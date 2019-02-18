<template>
  <ProblemTemplate title="Addition Problems" :operation="operation"/>
</template>

<script lang="ts">
import Vue from 'vue'
import Component from 'vue-class-component'

import ProblemTemplate from '@/components/ProblemTemplate.vue'

@Component({
  components: {
    ProblemTemplate
  }
})
export default class Add extends Vue {
  operation = {
    name: 'add',
    size: 10,
    min: 10,
    max: 99,
    duration: 2
  };
}
</script>
<style scoped>
</style>
