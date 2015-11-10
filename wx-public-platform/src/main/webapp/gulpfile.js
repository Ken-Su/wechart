var gulp = require('gulp')，
concat = require('gulp-concat')，
jshint=require('gulp-jshint');

// 语法检查
gulp.task('jshint'， function () {
    return gulp.src('js/*.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

// 压缩，合并 js
gulp.task('minifyjs'， function() {
    return gulp.src('js/*.js')      // 需要操作的文件
        .pipe(concat('wx_public_platform.js'))    // 合并所有js
        .pipe(gulp.dest('js'))       // 输出到文件夹
        //.pipe(rename({suffix: '.min'}))   // rename压缩后的文件名
        //.pipe(uglify())    // 压缩
        //.pipe(gulp.dest('Js'));  // 输出
});

//监视文件的变化
gulp.task('watch', function () {
    gulp.watch('src/*.js', ['jshint', 'minifyjs']);
});

// 默认命令，在cmd中输入gulp后，执行的就是这个任务(压缩js需要在检查js之后操作)
gulp.task('default'，['jshint', 'watch']，function() {
    gulp.start('minifyjs'); 
});