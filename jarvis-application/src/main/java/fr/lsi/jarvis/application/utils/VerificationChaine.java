package fr.lsi.jarvis.application.utils;

/**
 * Class util pour les chaines de charactère
 *
 * @author Laurent SION
 *
 */
public final class VerificationChaine {

	/**
	 * return nb Majuscule
	 *
	 * @param chaine
	 * @return
	 */
	public static int nbrMinuscule(final char[] chaine) {
		int compteur = 0;
		for (int i = 0; i < chaine.length; i++) {
			final char ch = chaine[i];
			if (Character.isLowerCase(ch)) {
				compteur++;
			}
		}
		return compteur;
	}

	/**
	 * Return nb minuscule
	 *
	 * @param chaine
	 * @return
	 */
	public static int nbrMajuscule(final char[] chaine) {
		int compteur = 0;
		for (int i = 0; i < chaine.length; i++) {
			final char ch = chaine[i];
			if (Character.isUpperCase(ch)) {
				compteur++;
			}
		}
		return compteur;
	}

	/**
	 * Return nb chiffre
	 *
	 * @param chaine
	 * @return
	 */
	public static int nbNumber(final char[] chaine) {

		int compteur = 0;
		for (int i = 0; i < chaine.length; i++) {
			final char ch = chaine[i];
			if (Character.isDigit(ch)) {
				compteur++;
			}
		}
		return compteur;
	}

	/**
	 * return nb spécial char
	 *
	 * @param chaine
	 * @return
	 */
	public static int nbCharSpec(final char[] chaine) {

		int compteur = 0;
		for (int i = 0; i < chaine.length; i++) {
			final char ch = chaine[i];
			if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
				compteur++;
			}
		}
		return compteur;

	}

	/**
	 * return true if null or empty
	 *
	 * @param chaine
	 * @return
	 */
	public static Boolean verifStringNotNullOoEmpty(final String chaine) {
		return ((chaine == null) || chaine.isEmpty());
	}

}
