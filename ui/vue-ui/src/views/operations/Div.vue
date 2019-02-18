<template>
  <ProblemTemplate title="Division Problems" :operation="operation"/>
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
export default class Divide extends Vue {
  operation = {
    name: 'div',
    size: 10,
    min: 2,
    max: 10,
    duration: 2
  };
}
</script>
<style scoped>
</style>
