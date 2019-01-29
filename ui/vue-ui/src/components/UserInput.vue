<template>
  <div class="user-input">
    <div class="inputForm" style="width: 200px;">
      <table width="80%">
        <tr>
          <td>Number of problems</td>
        </tr>
        <tr>
          <td>
            <input type="number" v-model.number="input.size" name="size">
          </td>
        </tr>
        <tr>
          <td>Starting Value</td>
        </tr>
        <tr>
          <td>
            <input type="number" v-model.number="input.min" name="min">
          </td>
        </tr>
        <tr>
          <td>Endoing Value</td>
        </tr>
        <tr>
          <td>
            <input type="number" v-model.number="input.max" name="max">
          </td>
        </tr>
      </table>
      <p>
        <button v-on:click="activateTimer">Start Timer</button>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "UserInput",
  data: function () {
    return {
      input: {
        size: this.size,
        min: this.min,
        max: this.max
      }
    };
  },
  props: {
    size: Number,
    min: Number,
    max: Number
  },
  methods: {
    activateTimer: function () {
      this.$emit(
        "activate-timer",
        this.input.size,
        this.input.min,
        this.input.max
      );
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.inputForm {
  display: inline-block;
  height: 200px;
  background-color: #aaa;
  padding: 20px;
  text-align: left;
  /* font-size: 70px; */
  margin-right: 10%;
  border: 2px solid #908b85;
  border-radius: 20px;
  box-shadow: 7px 10px 34px 1px rgba(0, 0, 0, 0.68),
    inset -1px -6px 12px 0.1px #89847e;
}
</style>
