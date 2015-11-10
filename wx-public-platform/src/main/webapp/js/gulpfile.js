var gulp = require('gulp'), 
	concat = require('gulp-concat'), 
	jshint = require('gulp-jshint');

gulp.task('jshint', function() {
	return gulp.src('modules/**/*.js').pipe(jshint()).pipe(jshint.reporter('default'));
});

gulp.task('minifyjs', function() {
	return gulp.src('modules/**/*.js') 
	.pipe(concat('wx_public_platform.js'))
	.pipe(gulp.dest(''))
});

gulp.task('watch', function() {
	gulp.watch('modules/**/*.js', [ 'jshint', 'minifyjs' ]);
});

gulp.task('default', [ 'jshint', 'watch' ], function() {
	gulp.start('minifyjs');
});