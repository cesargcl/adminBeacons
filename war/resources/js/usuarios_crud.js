/**
 * 
 */
$(document).ready(function() {

	var crudServiceBaseUrl = "/data", dataSource = new kendo.data.DataSource({
		transport : {
			read : {
				url : crudServiceBaseUrl + "/users.json",
				dataType : "json"
			},
			parameterMap : function(options, operation) {
				if (operation !== "read" && options.models) {
					return {
						models : kendo.stringify(options.models)
					};
				}
			}
		},
		batch : true,
		pageSize : 40,
		schema : {
			model : {
				id : "id",
				fields : {
					email : {
						editable : false
					},
					first_name : {
						editable : false
					},
					last_name : {
						editable : false
					},
					middle_name : {
						editable : false
					},
					gender : {
						editable : false
					},
					link : {
						editable : false
					},
					locale : {
						editable : false
					},
					name : {
						editable : false
					},
					timezone : {
						editable : false
					},
					updated_time : {
						editable : false
					},
					verified : {
						editable : false
					},
					celular : {
						editable : false
					}
				}
			}
		}
	});

	$("#grid").kendoGrid({
		dataSource : dataSource,
		pageable : true,
		height : 700,
		columns : [{
			field : "email"
		}, {
			field : "first_name"
		}, {
			field : "last_name"
		}, {
			field : "middle_name"
		}, {
			field : "gender"
		}, {
			field : "link"
		}, {
			field : "locale"
		}, {
			field : "name"
		}, {
			field : "timezone"
		}, {
			field : "updated_time"
		}, {
			field : "verified"
		}, {
			field : "celular"
		}]
	});
});