module.exports = {
  devServer: {
    proxy: {
      '^/api': {
        target: 'https://math.vpv.io',
        ws: true,
        changeOrigin: true
      }
    }
  }
}
