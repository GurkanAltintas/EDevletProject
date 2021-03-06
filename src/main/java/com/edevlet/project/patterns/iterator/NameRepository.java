package com.edevlet.project.patterns.iterator;

import java.util.List;

import com.edevlet.project.entity.db.Recipe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NameRepository implements Container {

	private class NameIterator implements Iterator {

		private int index = 0;

		@Override
		public boolean hasNext() {
			return index < recipeList.size();
		}

		@Override
		public Object next() {

			if (hasNext()) {
				return recipeList.get(index++);
			}

			return null;
		}

	}

	List<Recipe> recipeList;

	@Override
	public Iterator getIterator() {

		return new NameIterator();
	}

}
