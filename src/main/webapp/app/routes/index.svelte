<script>
	import auth from '../components/auth/auth-store.js'
	import appAvatar from '../components/svg/appAvatar.svg'
</script>

<svelte:head>
	<title>Welcome, Svelte Hipster!</title>
	<meta name="Description" content="SampleBlogApp home page" />
</svelte:head>

<section
	class="m-3 bg-white dark:bg-gray-800 shadow-lg rounded p-4 border border-gray-200 dark:border-gray-700 transition-colors duration-200"
>
	<div
		class="flex flex-col justify-center items-center sm:flex-row
			sm:justify-between"
	>
		<div
			class="w-1/2 sm:w-1/4 sm:h-auto sm:px-4 object-cover object-center"
		>
			<img src="{appAvatar}" alt="Avatar" />
		</div>

		<div class="sm:flex-grow sm:px-4">
			<h1 data-test="welcomeTitle" class="text-5xl">
				Welcome, Svelte Hipster!
			</h1>

			<p class="text-xl mt-2">This is your homepage</p>

			<div class="mt-4">
				{#if $auth}
					<div
						data-test="greetMsg"
						class="px-5 py-3 bg-green-100 dark:bg-green-800 text-green-900 dark:text-green-100 transition-colors duration-200 rounded"
					>
						<span>You are logged in as user "{$auth.login}".</span>
					</div>
				{:else}
					<div
						data-test="loginInstructions"
						class="px-5 py-3 bg-yellow-100 dark:bg-yellow-800 text-yellow-900 dark:text-yellow-100 rounded transition-colors duration-200"
					>
						<span>If you want to </span>
						<a class="font-semibold" href="/login">sign in</a><span
							>, you can try the default accounts:<br />-
							Administrator (login="admin" and password="admin")
							<br />- User (login="user" and password="user").</span
						>
					</div>
					<div
						class="px-5 py-3 mt-4 bg-yellow-100 dark:bg-yellow-800 text-yellow-900 dark:text-yellow-100 rounded transition-colors duration-200"
					>
						<span>You don't have an account yet?</span>&nbsp;
						<a
							data-test="svlRegisterHomeLink"
							class="font-semibold"
							href="/account/register">Register a new account</a
						>
					</div>
				{/if}
			</div>

			<p class="mt-4">If you have any question on JHipster:</p>

			<ul
				class="mt-4 pl-10 list-disc text-yellow-900 dark:text-yellow-200 font-semibold"
			>
				<li>
					<a
						href="https://www.jhipster.tech/"
						target="_blank"
						rel="noopener noreferrer">JHipster homepage</a
					>
				</li>
				<li>
					<a
						href="https://stackoverflow.com/tags/jhipster/info"
						target="_blank"
						rel="noopener noreferrer">JHipster on Stack Overflow</a
					>
				</li>
				<li>
					<a
						href="https://github.com/jhipster/generator-jhipster-svelte/issues?state=open"
						target="_blank"
						rel="noopener noreferrer">JHipster Svelte bug tracker</a
					>
				</li>
				<li>
					<a
						href="https://gitter.im/jhipster/generator-jhipster"
						target="_blank"
						rel="noopener noreferrer">JHipster public chat room</a
					>
				</li>
				<li>
					<a
						href="https://twitter.com/jhipster"
						target="_blank"
						rel="noopener noreferrer">follow @jhipster on Twitter</a
					>
				</li>
			</ul>

			<p class="mt-4">
				<span
					>If you like JHipster Svelte, don't forget to give us a star
					on</span
				>
				<a
					class="font-semibold text-yellow-900 dark:text-yellow-200"
					href="https://github.com/jhipster/generator-jhipster-svelte"
					target="_blank"
					rel="noopener noreferrer">GitHub</a
				>!
			</p>
		</div>
	</div>
</section>
