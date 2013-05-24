package clinique.mapping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity<E extends Entity<E>> implements Serializable {
	private static final long serialVersionUID = -877401066756790636L;

	protected abstract E createEntity();

	public abstract void updateWith(E entity);

	public static class EntityCopier<E extends Entity<E>> {
		public List<E> copyList(List<E> entities) {
			if (entities == null) {
				return null;
			}
			List<E> copy = new ArrayList<E>();
			for (E e : entities) {
				copy.add(copy(e));
			}
			return copy;
		}

		public E copy(E entity) {
			if (entity == null) {
				return null;
			}
			E copy = entity.createEntity();
			copy.updateWith(entity);
			return copy;
		}
	}
}
