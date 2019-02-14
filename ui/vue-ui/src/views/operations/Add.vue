<template>
  <ProblemTemplate title="Addition Problems" :operation="operation"/>
</template>

<script>
import ProblemTemplate from '@/components/ProblemTemplate.vue'

export default {
  name: 'add',
  components: {
    ProblemTemplate
  },
  data: function () {
    return {
      operation: {
        name: 'add',
        size: 10,
        min: 10,
        max: 99,
        duration: 2
      }
    }
  }
}
</script>
<style scoped>
</style>
