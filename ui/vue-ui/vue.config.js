module.exports = {
  devServer: {
    proxy: {
      '^/api': {
        host: 'localhost',
        target: 'https://math.vpv.io',
        ws: true,
        changeOrigin: true,
        headers: {
          host: 'math.vpv.io'
        }
      },
      '/login': {
        target: 'https://math.vpv.io',
        host: 'localhost',
        changeOrigin: false,
        headers: {
          host: 'math.vpv.io'
        },
        pathRewrite: {
          '/login': '/login'
        }
      }
    }
  }
}
