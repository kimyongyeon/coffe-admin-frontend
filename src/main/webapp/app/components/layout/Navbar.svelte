<script>
	import { faBars } from '@fortawesome/free-solid-svg-icons/faBars'
	import { faSignInAlt } from '@fortawesome/free-solid-svg-icons/faSignInAlt'
	import { faUserPlus } from '@fortawesome/free-solid-svg-icons/faUserPlus'

	import applogo from 'images/logo-jhipster.png'
	import Icon from '../Icon.svelte'
	import NavItem from './NavItem.svelte'
	import auth from '../auth/auth-store.js'
	import AccountMenu from './AccountMenu.svelte'
	import AdminMenu from './AdminMenu.svelte'
	import RoleGuard from '../auth/RoleGuard.svelte'
	import ThemeModeToggle from './ThemeModeToggle.svelte'

	let isToolbarOpen = false

	function toggleToolbar() {
		isToolbarOpen = !isToolbarOpen
	}
</script>

<header
	class="sticky top-0 w-full bg-gray-800 sm:flex sm:justify-between items-center sm:px-4 sm:py-3 shadow-md"
>
	<div class="flex items-center justify-between px-4 py-3 sm:p-0">
		<div class="flex items-baseline justify-between text-gray-100">
			<a href="/" on:click="{() => (isToolbarOpen = false)}"
				><img
					width="48px"
					height="20px"
					class="w-12 m-auto"
					src="{applogo}"
					alt="Application logo"
				/></a
			>
			<div data-test="svlAppName" class="ml-2 font-semibold text-xl">
				SampleBlogApp
			</div>
			<div data-test="svlAppVersion" class="ml-2 text-xs text-gray-400">
				DEV
			</div>
		</div>
		<div class="flex flex-row justify-items-end items-center">
			<div class="block sm:hidden mr-2">
				<ThemeModeToggle />
			</div>
			<div class="sm:hidden">
				<button
					data-test="svlNavBtn"
					on:click="{toggleToolbar}"
					type="button"
					aria-label="Toggle Navigation"
					class="block px-2 py-1 hover:text-white
						focus:outline-none focus:ring focus:ring-primary-500 rounded
						focus:text-white text-gray-400 leading-none"
				>
					<Icon icon="{faBars}" />
				</button>
			</div>
		</div>
	</div>
	<div class:hidden="{!isToolbarOpen}" class="sm:flex sm:items-center">
		<div class="hidden sm:block">
			<ThemeModeToggle />
		</div>
		{#if $auth}
			<RoleGuard role="ADMIN">
				<div data-test="svlAdminMenu" class="sm:ml-4">
					<AdminMenu />
				</div>
			</RoleGuard>
			<div data-test="svlAcctMenu" class="sm:ml-4">
				<AccountMenu />
			</div>
		{:else}
			<div data-test="svlLoginLink" class="sm:ml-4">
				<NavItem
					on:click="{toggleToolbar}"
					label="Sign in"
					icon="{faSignInAlt}"
					route="/login"
				/>
			</div>
			<div data-test="svlRegisterLink" class="sm:ml-4 pb-3 sm:pb-0">
				<NavItem
					on:click="{toggleToolbar}"
					label="Sign up"
					icon="{faUserPlus}"
					route="/account/register"
				/>
			</div>
		{/if}
	</div>
</header>
