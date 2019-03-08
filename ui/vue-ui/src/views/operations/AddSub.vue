<template>
  <ProblemTemplate title="Mixed Problems" :operation="operation"/>
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
export default class AdditionSubtraction extends Vue {
  operation = {
    name: 'addsub',
    size: 90,
    min: 1,
    max: 20,
    duration: 2
  };
}
</script>
<style scoped>
</style>
