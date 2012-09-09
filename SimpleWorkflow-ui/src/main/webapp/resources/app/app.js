/**
 * 
 */
Ext.Loader.setConfig({ 
    enabled: true 
});

Ext.require([
	'Ext.grid.*',
	'Ext.data.*',
	'Ext.util.*',
	'Ext.state.*',
	'Ext.form.*',
	'Ext.tip.*',
	'Ext.Button'
]);

Ext.application({
	name: 'Ins',
	appFolder: 'resources/app',
	controllers: [
	    'CustomerController'
	],
	launch: function() {
		Ext.create('Ext.container.Viewport', {
		    layout: {
		        type: 'border',
		        padding: 5
		    },
		    defaults: {
		        split: true
		    },
		    bodyStyle: {
	            'background-color': '#e5e5e5'
	        },
		    items: [{
		        region: 'north',
		        xtype: 'box',
		        id: 'northcont',
		        collapsible: false, 
		        border: false,
		        split: true,
		        height: 80,
		        html: 	
		        	'<nav id="access" role="navigation">' +
							'<div class="fluid">' +
								'<div class="menu">' +
									'<ul>' +
										'<li><a href="/SimpleWorkflow" title="Home">Home</a></li>' +
										'<li><a href="/SimpleWorkflow/flow/customer" title="Customers">Customers</a></li>' +
										'<li><a href="/SimpleWorkflow/flow/proposal" title="Proposals">Proposals</a></li>' +
										'<li><a href="/SimpleWorkflow/flow/underWrite" title="Under Writing">Under Writing</a></li>' +
										'<li><a href="/SimpleWorkflow/flow/claim" title="Claims">Claims</a></li>' +
										'<li><a href="/SimpleWorkflow/flow/account" title="Accounting">Accounting</a></li>' +
									'</ul>' +
								'</div>' +
							'</div>' +
						'</nav>'

		    },{
		        region: 'west',
		        itemId: 'westContentPanel',
		        collapsible: false, 
		        border: false,
		        width: '15%',
		        split: true,
		        layout: {
		            type: 'card'
		        },
		        style: {
		            'background-color': '#fff',
		            'border-radius': '4px 4px 4px 4px',
		            'box-shadow': '0 0 2px rgba(0, 0, 0, 0.3)'
		        },
		        bodyStyle: {
		            'color': '#646464'
		        }
		    },{
		        region: 'center',
		        itemId: 'centerContentPanel',
		        xtype: 'container',
		        border: false,
		        style: {
		            'background-color': '#fff',
		            'padding': '20px',
		            'border-radius': '4px 4px 4px 4px',
		            'box-shadow': '0 0 2px rgba(0, 0, 0, 0.3)'
		        },
		        bodyStyle: {
		            'color': '#646464'
		        },
		        items: [{
		        	xtype: 'customerlist'
		        }]
		    }]
		});
	}
});