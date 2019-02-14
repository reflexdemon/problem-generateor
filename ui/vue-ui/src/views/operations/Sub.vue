<template>
  <ProblemTemplate title="Subtraction Problems" :operation="operation"/>
</template>

<script>
import ProblemTemplate from '@/components/ProblemTemplate.vue'

export default {
  name: 'subtract',
  components: {
    ProblemTemplate
  },
  data: function () {
    return {
      operation: {
        name: 'sub',
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
