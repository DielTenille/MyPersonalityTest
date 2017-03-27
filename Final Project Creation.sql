

CREATE TABLE public.Assessment_questions(
	question SERIAL PRIMARY KEY,
    dOption	character varying(75)	NOT NULL,
    iOption	character varying(75)	NOT NULL,
	sOption	character varying(75)	NOT NULL,
	cOption	character varying(75)	NOT NULL
);

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Likes authority', 'Enthusiastic', 'Sensitive feelings', 'Likes instructions');


INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Takes charge', 'Takes risks', 'Loyal', 'Accurate');


INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Determined', 'Visionary', 'Calm, even keel', 'Consistent');


INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Enterprising', 'Very verbal', 'Enjoys routine', 'Predictable');


INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Competitive', 'Promoter', 'Dislikes change', 'Practical');

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Problem-solver', 'Enjoys popularity', 'Gives in to others', 'Factual');

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Productive', 'Fun-loving', 'Avoids confrontation', 'Conscientious');

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Bold', 'Likes variety', 'Sympathetic', 'Perfectionistic');

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Decision maker', 'Spontaneous', 'Nurturing', 'Detail-orientated');

INSERT INTO public.Assessment_questions (dOption, iOption, sOption, cOption)
VALUES ('Persistent', 'Inspirational', 'Peacemaker', 'Analytical');

