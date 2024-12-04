; ***************************************  CHATBOT ELIZA  ***************************************
;==========================================================|
;                                                          |                                                         
; Auteur : NAZE WENDYAM KAROL SAMIR                          |                                       
;                                                          |
;==========================================================|

; ******* Les variables globales *******

(defparameter *bindings* nil)


(defparameter *reponse*
    '(
        ((Bonjour *) (Bonjour comment allez-vous ?))
        ((je vais * x ) (Pourquoi allez vous x ? ))
        ((et vous ?) (Bon parlons plutôt de vous si vous le voulez bien.))
        ((je suis allé * x) (Ah et avez-vous aimé le fait d'aller x du coup ?))
        ((j ai vu *) (Dites moi ce que vous en pensez ))
        ((j aime bien * x) (Je vois et d'où vous vient ce petit penchant d'après vous ? ))
        ((je deteste * y) (Pourquoi vous detestez y ?))
        ((tu es *) (Ce n'est que votre avis que je respecte.))
        ((*) (je comprends.))
    )
)



; ******* Les fonctions *******

(defun match-eq(arg1 arg2)
    (if (null arg1)
        (null arg2)
        (if (eq (first arg1) (first arg2))
            (match-eq (rest arg1) (rest arg2))
            nil
        )
    )
)


(defun chercher(key alist)
    (if(null alist)
        nil
        (if (null (find key (first alist)))
            (chercher key (rest alist))
            (setf *rlist* (first alist))
        )
    )
)


(defun match(arg1 arg2)
    (if (null arg1)
        (null arg2)
        (if (eq (first arg1) (first arg2))
            (match (rest arg1) (rest arg2))
            (if (eq (first arg1) '*)
                (wildcard arg1 arg2)
                nil
            )
        )
    )
)


(defun wildcard (arg1 arg2)
    (if (match (rest (rest arg1)) arg2)
        (progn (setf *bindings*
            (affecter (first (rest arg1)) nil *bindings*)) t)

    (if (null arg2)
        nil
        (if (match arg1 (rest arg2))
            (progn (setf *bindings*
                (affecter (first (rest arg1)) (first arg2) *bindings*))t)
        nil
        )
    )
     
    )
)



(defun affecter (var value *bindings*)
    (if (null *bindings*)
        (list (if value (list var value) (list var)))
        (let* ((key (first (first *bindings*)))
            (values (rest (first *bindings*)))
            (new value))
        (if (eq var key)
            (cons (cons key (cons new values)) (rest *bindings*))
            (cons (first *bindings*) (affecter var new (rest *bindings*)))
          )
          )
        )
  )


(defun subs (list)
    (if (null list)
        nil
        (let ((a (chercher (first list) *bindings*)))
             (if
                a 
                (append (rest a) (subs (rest list)))
                (cons (first list) (subs (rest list)))
             )
        )
    )
)



(defun start()
    (loop
        (princ "YOU > ")
        (let* ((line (read-line))
            (input (read-from-string (concatenate 'string "(" line ")"))))
            (when (string= line "bye") (return))
            (setq *bindings* nil)
            (format t "ELIZA > ~{~(~a ~)~}~%"
                (dolist (r *reponse*)
                    (when (match (first r) input)
                        (return
                            (subs (car (rest r)))
                        )
                    )
            )
        )

    
    )
))



; ******* Les tests des fonctions *******

; Test de la fonction match-eq
;(trace match-eq)
;(match-eq '(Nissa est belle) '(Nissa est belle))
;(match-eq '(Nissa est belle) '(Nissa est moche))

;----------------------------------------------------------------------

; Test de la fonction match
;(matcg '(je * X le projet) '(je fait le projet))
;(match '(* x fait * y à * z) '(Samir fait peur à Nissa))
;(print *bindings*)

;----------------------------------------------------------------------

; Test de la fonction wildcard
;(trace wildcard)
;(wildcard '(* x aime * y) '(Samir aime Nissa))
;(print *bindings*)

;----------------------------------------------------------------------

;Test de la fonction chercher
;(match '(* x aime *y) '(Samir aime Nissa))
;(print(chercher 'Y *bindings*))
;(print(chercher 'X *bindings*))

;----------------------------------------------------------------------

; Test de la fonction subs
;(match '(* x aime *y) '(Samir aime Nissa))
;(print(subs'(j'aime bien X)))


; ******* Fonction principale du chatbot *******

(start)
