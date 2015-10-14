/**
 * 
 */
$(document).ready(function() {

	var crudServiceBaseUrl = "/data", dataSource = new kendo.data.DataSource({
		transport : {
			read : {
				url : crudServiceBaseUrl + "/beacons.json",
				dataType : "json"
			},
			update : {
				url : crudServiceBaseUrl + "/beacons/update.json",
				dataType : "json"
			},
			destroy : {
				url : crudServiceBaseUrl + "/beacons/destroy.json",
				dataType : "json"
			},
			create : {
				url : crudServiceBaseUrl + "/beacons/create.json",
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
					id : {
						editable : false,
						nullable : true
					},
					uuid : {
						validation : {
							required : true
						}
					},
					nombre : {
						editable : true
					},
					major : {
						type : "number",
						validation : {
							min : 0,
							required : true
						}
					},
					minor : {
						type : "number",
						validation : {
							min : 0,
							required : true
						}
					},
					descripcion : {
						validation : {
							required : true
						}
					},
					codeScreen : {
						validation : {
							required : true
						}
					},
					mensaje : {
						validation : {
							required : true
						}
					}
				}
			}
		}
	});

	$("#grid").kendoGrid({
		dataSource : dataSource,
		pageable : true,
		height : 700,
		toolbar : [ "create" ],
		columns : [ {
			field : "uuid",
			title : "UUID",
			width : "200px"
		}, {
			field : "nombre",
			title : "Nombre",
			width : "200px"
		}, {
			field : "major",
			width : "100px"
		}, {
			field : "minor",
			width : "100px"
		}, {
			field : "descripcion"
		}, {
			field : "codeScreen",
			width : "100px"
		}, {
			field : "mensaje"
		}, {
			command : [ "edit", "destroy" ],
			title : "",
			width : "172px"
		} ],
		editable : "popup"
	});
});