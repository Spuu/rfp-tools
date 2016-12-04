package org.reksio.rfp.tools.rest.requests

import groovyx.net.http.RESTClient
import org.reksio.rfp.tools.rest.api.IRestApiCall
import org.reksio.rfp.tools.smallbusiness.gizmo.Document
import org.reksio.rfp.tools.smallbusiness.types.Product

import static groovyx.net.http.ContentType.*

/**
 * Create new product
 * POST: http(s)://<url>/api/product
 */
class CreateProduct implements IRestApiCall {

    Product product

    /**
     * Ctor: takes document and sets props in rest call
     */
    CreateProduct(Document doc) {
        this.product = new Product(doc)
    }

    /**
     * Ctor: takes product and sets props in rest call
     */
    CreateProduct(Product obj) {
        this.product = obj
    }

    /**
     * Execute rest call
     */
    def call(RESTClient client) {
        return client.post(
                path : '/api/product',
                body: [
                        name: product.name,
                        ean : product.symbol
                ],
                requestContentType : JSON
        )
    }
}
