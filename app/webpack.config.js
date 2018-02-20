/**
 * This will bundle up the demo page and serve it with the webpack dev
 * server. Run `yarn start:dev`.
 */
const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');

const babelLoader = {
    loader: 'babel-loader',
    options: {
        cacheDirectory: true,
        presets: [
            'react',
            ['es2015', { 'modules': false }],
            'es2016',
        ],
    },
};

module.exports = {
    devtool: 'inline-source-map',
    entry: {
        demo: './src/index.tsx',
    },
    output: {
        path: path.resolve(__dirname, 'dist'),
        filename: 'bundle.js',
    },
    module: {
        rules: [
            {
                test: /\.ts(x?)$/,
                exclude: /node_modules/,
                use: [babelLoader, { loader: 'ts-loader' }],
            },
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [babelLoader]
            },
        ]
    },
    plugins: [
        new HtmlWebpackPlugin({ template: 'index.html' }),
    ],
    resolve: {
        extensions: ['.ts', '.tsx', '.js'],
    },
    devServer: {
        compress: true,
        port: 8032,
        proxy: {
            "/application/api": {
                target: "http://localhost:8021"
            }
        }
    },
};
