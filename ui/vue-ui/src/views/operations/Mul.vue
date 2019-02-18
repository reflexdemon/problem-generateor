<template>
  <ProblemTemplate title="Multiplication Problems" :operation="operation"/>
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
export default class Multiply extends Vue {
  operation = {
    name: 'mul',
    size: 10,
    min: 2,
    max: 10,
    duration: 2
  };
}
</script>
<style scoped>
</style>
