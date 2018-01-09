/*
 * Copyright 2017 Arthur Gregorio, AG.Software.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.eti.arthurgregorio.library.domain.services;

import br.eti.arthurgregorio.library.domain.entities.Author;
import br.eti.arthurgregorio.library.domain.entities.Book;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import br.eti.arthurgregorio.library.domain.repositories.AuthorRepository;
import br.eti.arthurgregorio.library.domain.repositories.BookRepository;
import javax.transaction.Transactional;

/**
 *
 * @author Arthur Gregorio
 *
 * @since 1.0.0
 * @version 1.0.0, 15/12/2017
 */
@ApplicationScoped
public class LibraryService {

    @Inject
    private BookRepository bookRepository;
    @Inject
    private AuthorRepository authorRepository;

    /**
     * 
     * @param livro
     * @return 
     */
    @Transactional
    public Book save(Book livro) {
        return this.bookRepository.save(livro);
    }

    /**
     * 
     * @param autor
     * @return 
     */
    @Transactional
    public Author save(Author autor) {
        return this.authorRepository.save(autor);
    }

    /**
     * 
     * @param idAuthor
     * @return 
     */
    public Author findAuthorById(long idAuthor) {
        return this.authorRepository.findOptionalById(idAuthor)
                .orElseThrow(() -> 
                        new IllegalArgumentException("Nenhum autor localizado"));
    }
}