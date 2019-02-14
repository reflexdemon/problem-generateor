<template>
  <ProblemTemplate title="Multiplication Problems" :operation="operation"/>
</template>

<script>
import ProblemTemplate from '@/components/ProblemTemplate.vue'

export default {
  name: 'multiply',
  components: {
    ProblemTemplate
  },
  data: function () {
    return {
      operation: {
        name: 'mul',
        size: 10,
        min: 2,
        max: 10,
        duration: 2
      }
    }
  }
}
</script>
<style scoped>
</style>
