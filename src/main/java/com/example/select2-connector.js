window.com_example_Select2Component = function () {
    var parentElement = $(this.getElement());
    var state = this.getState();

    parentElement.select2({
        data: state.data,
        multiple: true
    });

    var self = this;
    parentElement.on("change", function(e) {
        self.onChange(e.val);
    });

}