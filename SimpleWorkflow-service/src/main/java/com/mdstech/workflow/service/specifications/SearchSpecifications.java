package com.mdstech.workflow.service.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.mdstech.workflow.domain.customer.Customer;
import com.mdstech.workflow.domain.customer.Customer_;

public class SearchSpecifications {
	public static Specification<Customer> firstNameOrlastNameIsLike(
			final String searchTerm) {
		return new Specification<Customer>() {
			public Predicate toPredicate(final Root<Customer> customerRoot,
					final CriteriaQuery<?> query, final CriteriaBuilder cb) {
				final String likePattern = getLikePattern(searchTerm);
				return cb
						.or(cb.like(cb.lower(customerRoot
								.<String> get(Customer_.firstName)),
								likePattern),
								cb.like(cb.lower(customerRoot
										.<String> get(Customer_.lastName)),
										likePattern));
			}

			private String getLikePattern(final String searchTerm) {
				final StringBuilder pattern = new StringBuilder();
				pattern.append(searchTerm.toLowerCase());
				pattern.append("%");
				return pattern.toString();
			}
		};
	}

}
