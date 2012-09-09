/**
 * 
 */
Ext.define('Ins.model.Address', {
	 extend: 'Ext.data.Model',
//	 requires: ['Ext.data.BelongsToAssociation'],
	 fields: [
	    'addressType',
	    'addrStreet',
	    'addrStreetExt',
	    'city',
	    'state',
	    'country',
	    'postalCode',
	    'primary',
	    'customerid',
	    'id'
	 ]
//	 belongsTo: {
//		 model: 'Ins.model.Customer', 
//		 foreignKey: 'customerid'
//	 }
});