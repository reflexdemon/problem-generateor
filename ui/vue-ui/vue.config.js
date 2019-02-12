module.exports = {
  devServer: {
    proxy: {
      '^/api': {
        host: 'localhost',
        target: 'http://localhost:9090',
        ws: true,
        changeOrigin: true,
        headers: {
          host: 'localhost:8080'
        }
      },
      '/login': {
        target: 'http://localhost:9090',
        host: 'localhost',
        changeOrigin: false,
        headers: {
          host: 'localhost:8080'
        },
        pathRewrite: {
          '/login': '/login'
        }
      }
    }
  }
}
